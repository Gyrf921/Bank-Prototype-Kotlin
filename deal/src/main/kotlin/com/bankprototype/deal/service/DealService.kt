package com.bankprototype.deal.service

import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanOfferDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.springframework.stereotype.Service

@Service
interface DealService {
    fun calculatePossibleLoanTerms(loanStatementRequestDto: LoanStatementRequestDto): List<LoanOfferDto>
    fun selectOneLoanOffer(loanOfferDto: LoanOfferDto)
    fun calculateTotalCredit(statementId: String, finishRegistrationRequestDto: FinishRegistrationRequestDto)
}