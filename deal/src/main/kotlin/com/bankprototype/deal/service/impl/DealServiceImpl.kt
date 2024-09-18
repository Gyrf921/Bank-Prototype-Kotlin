package com.bankprototype.deal.service.impl

import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.dao.enumforobject.ChangeType
import com.bankprototype.deal.dao.enumforobject.CreditStatus
import com.bankprototype.deal.dao.factory.StatementFactory
import com.bankprototype.deal.dao.jsonb.StatusHistory
import com.bankprototype.deal.mapper.ClientMapper
import com.bankprototype.deal.mapper.CreditMapper
import com.bankprototype.deal.mapper.ScoringMapper
import com.bankprototype.deal.repository.ClientRepository
import com.bankprototype.deal.repository.CreditRepository
import com.bankprototype.deal.repository.StatementRepository
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanOfferDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import com.bankprototype.deal.web.feign.CalculatorFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Service
class DealServiceImpl @Autowired constructor(
    private val clientRepository: ClientRepository,
    private val statementRepository: StatementRepository,
    private val creditRepository: CreditRepository,
    private val clientMapper: ClientMapper,
    private val creditMapper: CreditMapper,
    private val scoringMapper: ScoringMapper,
    private val statementFactory: StatementFactory,
    private val calculatorFeignClient: CalculatorFeignClient,
) {

    fun calculatePossibleLoanTerms(loanStatementRequestDto: LoanStatementRequestDto) : List<LoanOfferDto> {

        var client = clientMapper.loanStatementRequestDtoToClient(loanStatementRequestDto)

        client = clientRepository.save(client)
        val statement = statementRepository.save(statementFactory.createStatement(client))

        var loanOffers = calculatorFeignClient.possibleLoanTerms(loanStatementRequestDto).body

        loanOffers!!.stream().forEach { loanOffer -> loanOffer.statementId = statement.statementId}

        return loanOffers
    }

    fun selectOneLoanOffer(loanOfferDto: LoanOfferDto){

        var statement = statementRepository.getReferenceById(loanOfferDto.statementId!!)
        statement.applicationOffer = loanOfferDto

        statement.applicationStatus = ApplicationStatus.APPROVED
        statement.statusHistory = statement.statusHistory!!.plus(
            StatusHistory(
                ApplicationStatus.APPROVED,
                Timestamp.valueOf(LocalDateTime.now()),
                ChangeType.AUTOMATIC)
        )

        statementRepository.save(statement)

    }


    fun calculateTotalCredit(statementId: String, finishRegistrationRequestDto: FinishRegistrationRequestDto){

        var statement = statementRepository.getReferenceById(UUID.fromString(statementId))

        var scoringDataDto = scoringMapper.finishRegistrationRequestDtoToScoringDataDto(finishRegistrationRequestDto, statement.client!!)

        var credit = creditMapper.creditDtoToCredit(calculatorFeignClient.calculationTotalParams(scoringDataDto).body!!)

        credit.creditStatus = CreditStatus.CALCULATED

        creditRepository.save(credit)

        statement.applicationStatus = ApplicationStatus.CC_APPROVED
        statement.statusHistory = statement.statusHistory!!.plus(
            StatusHistory(
                ApplicationStatus.CC_APPROVED,
                Timestamp.valueOf(LocalDateTime.now()),
                ChangeType.AUTOMATIC)
        )

        statementRepository.save(statement)
    }
}