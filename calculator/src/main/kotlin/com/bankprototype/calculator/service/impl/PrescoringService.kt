package com.bankprototype.calculator.service.impl

import com.bankprototype.calculator.web.dto.LoanOfferDto
import com.bankprototype.calculator.web.dto.LoanStatementRequestDto
import com.bankprototype.calculator.service.factory.LoanOfferFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PrescoringService @Autowired constructor(private val loanOfferFactory: LoanOfferFactory){

    fun calculateLoanOffers(loanStatementRequestDto: LoanStatementRequestDto): List<LoanOfferDto> {
        var loanOffers: MutableList<LoanOfferDto> = mutableListOf()

        var loanOfferDto = loanOfferFactory.createLoanOffer(loanStatementRequestDto, isInsuranceEnabled = true, isSalaryClient = true)

        loanOffers.add(loanOfferFactory.createLoanOffer(loanStatementRequestDto, isInsuranceEnabled = true, isSalaryClient = true))
        loanOffers.add(loanOfferFactory.createLoanOffer(loanStatementRequestDto, isInsuranceEnabled = true))
        loanOffers.add(loanOfferFactory.createLoanOffer(loanStatementRequestDto, isSalaryClient = true))
        loanOffers.add(loanOfferFactory.createLoanOffer(loanStatementRequestDto))

        return loanOffers
    }

}