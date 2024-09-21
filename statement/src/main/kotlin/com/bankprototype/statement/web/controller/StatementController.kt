package com.bankprototype.statement.web.controller

import com.bankprototype.statement.service.StatementService
import com.bankprototype.statement.web.dto.LoanOfferDto
import com.bankprototype.statement.web.dto.LoanStatementRequestDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/statement")
class StatementController @Autowired constructor(
    private val statementService: StatementService
){
    @Operation(summary = "Prescoring", description = "Returns 200 if successful")
    @PostMapping
    fun prescoringCalculationPossibleLoanOffers(loanStatementRequestDto: LoanStatementRequestDto) : ResponseEntity<List<LoanOfferDto>>
    = ResponseEntity.ok().body(statementService.getLoanOffers(loanStatementRequestDto))

    @Operation(summary = "choose Loan Offer", description = "Returns 200 if successful")
    @PostMapping("/offer")
    fun chooseLoanOffer(loanOfferDto: LoanOfferDto)
    = statementService.chooseLoanOffer(loanOfferDto)

}