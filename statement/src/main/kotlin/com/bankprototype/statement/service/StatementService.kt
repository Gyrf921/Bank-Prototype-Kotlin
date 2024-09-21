package com.bankprototype.statement.service

import com.bankprototype.statement.web.dto.LoanOfferDto
import com.bankprototype.statement.web.dto.LoanStatementRequestDto
import org.springframework.stereotype.Service

@Service
interface StatementService {

    fun getLoanOffers(loanStatementRequestDto: LoanStatementRequestDto): List<LoanOfferDto>

    fun chooseLoanOffer(loanOfferDto: LoanOfferDto)
}