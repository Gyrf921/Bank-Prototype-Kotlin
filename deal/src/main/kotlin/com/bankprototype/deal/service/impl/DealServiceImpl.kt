package com.bankprototype.deal.service.impl

import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.service.DealService
import com.bankprototype.deal.service.db.ClientService
import com.bankprototype.deal.service.db.CreditService
import com.bankprototype.deal.service.db.StatementService
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanOfferDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import com.bankprototype.deal.web.feign.CalculatorFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DealServiceImpl @Autowired constructor(
    private val clientService: ClientService,
    private val statementService: StatementService,
    private val creditService: CreditService,
    private val calculatorFeignClient: CalculatorFeignClient,
) : DealService {

    override fun calculatePossibleLoanTerms(loanStatementRequestDto: LoanStatementRequestDto) : List<LoanOfferDto> {

        val statement = statementService.saveStatementFromClient(
            clientService.saveClientFromLoanStatementRequest(loanStatementRequestDto))

        val loanOffers = calculatorFeignClient.possibleLoanTerms(loanStatementRequestDto).body

        loanOffers!!.stream().forEach { loanOffer -> loanOffer.statementId = statement.statementId}

        return loanOffers
    }

    override fun selectOneLoanOffer(loanOfferDto: LoanOfferDto) =
        statementService.setApplicationOffer(loanOfferDto)


    override fun calculateTotalCredit(statementId: String, finishRegistrationRequestDto: FinishRegistrationRequestDto){

        var statement = statementService.getStatementById(UUID.fromString(statementId))
        val credit = creditService.saveCreditFromScoringData(finishRegistrationRequestDto, statement)

        statement.credit = credit
        statementService.changeApplicationStatus(statement, ApplicationStatus.PREPARE_DOCUMENTS)
        statementService.saveStatement(statement)

        val client = clientService.updateClientFromFinishRegistrationDto(statement.client!!, finishRegistrationRequestDto)
        clientService.saveClient(client)
    }
}