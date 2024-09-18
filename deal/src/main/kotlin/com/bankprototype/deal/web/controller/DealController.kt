package com.bankprototype.deal.web.controller

import com.bankprototype.deal.service.impl.DealServiceImpl
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanOfferDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/deal")
class DealController @Autowired constructor(
    private val dealServiceImpl: DealServiceImpl
)
{

    @PostMapping("/statement")
    fun calculatePossibleLoanTerms(@RequestBody loanStatementRequestDto: LoanStatementRequestDto)
            : ResponseEntity<List<LoanOfferDto>> = ResponseEntity.ok().body(dealServiceImpl.calculatePossibleLoanTerms(loanStatementRequestDto))

    @PostMapping("/offer/select")
    fun selectOneOfOffers(@RequestBody loanOfferDto: LoanOfferDto)
    = dealServiceImpl.selectOneLoanOffer(loanOfferDto)

    @PostMapping("/calculate/{statementId}")
    fun finishRegistration(@PathVariable("statementId") statementId: String,
                           @RequestBody finishRegistrationRequestDto: FinishRegistrationRequestDto)
    = dealServiceImpl.calculateTotalCredit(statementId, finishRegistrationRequestDto)

}