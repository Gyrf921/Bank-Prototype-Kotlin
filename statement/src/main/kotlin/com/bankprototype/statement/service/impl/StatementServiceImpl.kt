package com.bankprototype.statement.service.impl

import com.bankprototype.statement.service.StatementService
import com.bankprototype.statement.web.dto.LoanOfferDto
import com.bankprototype.statement.web.dto.LoanStatementRequestDto
import com.bankprototype.statement.web.feign.DealFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service

@Service
class StatementServiceImpl @Autowired constructor(
    private val dealFeignClient: DealFeignClient
) : StatementService {
    override fun getLoanOffers(loanStatementRequestDto: LoanStatementRequestDto): List<LoanOfferDto>
    = dealFeignClient.calculatePossibleLoanTerms(loanStatementRequestDto).body!!
    //TODO exception handler

    override fun chooseLoanOffer(loanOfferDto: LoanOfferDto)
    = dealFeignClient.selectOneOfOffers(loanOfferDto)
}