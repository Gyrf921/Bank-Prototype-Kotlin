package com.bankprototype.deal.service.db.impl

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Credit
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.dao.enumforobject.CreditStatus
import com.bankprototype.deal.mapper.CreditMapper
import com.bankprototype.deal.mapper.ScoringMapper
import com.bankprototype.deal.repository.CreditRepository
import com.bankprototype.deal.service.db.CreditService
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.feign.CalculatorFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreditServiceImpl @Autowired constructor(
    private val creditRepository: CreditRepository,
    private val creditMapper: CreditMapper,
    private val scoringMapper: ScoringMapper,
    private val calculatorFeignClient: CalculatorFeignClient,
) : CreditService {

    override fun saveCreditFromScoringData(frrDto: FinishRegistrationRequestDto, statement: Statement): Credit
    = creditRepository.save(
        creditMapper.creditDtoToCredit(
            calculatorFeignClient.calculationTotalParams(
                scoringMapper.finishRegistrationRequestDtoToScoringDataDto(frrDto, statement)).body!!))

}