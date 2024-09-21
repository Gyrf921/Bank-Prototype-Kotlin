package com.bankprototype.statement.web.controller

import com.bankprototype.statement.web.dto.LoanOfferDto
import com.bankprototype.statement.web.dto.LoanStatementRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/statement")
class StatementController {

    @PostMapping
    fun prescoringCalculationPossibleLoanOffers(loanStatementRequestDto: LoanStatementRequestDto) : ResponseEntity<List<LoanOfferDto>>{
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @PostMapping
    fun chooseLoanOffer(loanOfferDto: LoanOfferDto) {

    }
}