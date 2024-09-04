package com.bankprototype.calculator.web.controller

import com.bankprototype.calculator.service.impl.PrescoringService
import com.bankprototype.calculator.service.impl.ScoringService
import com.bankprototype.calculator.web.dto.CreditDto
import com.bankprototype.calculator.web.dto.LoanOfferDto
import com.bankprototype.calculator.web.dto.LoanStatementRequestDto
import com.bankprototype.calculator.web.dto.ScoringDataDto
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/calculator")
class CalculatorController @Autowired constructor(
    private val prescoringService: PrescoringService,
    private val scoringService: ScoringService
){

    @Operation(summary = "Sets a price for a chosen car", description = "Returns 202 if successful")
    @PostMapping("/offers")
    fun possibleLoanTerms(@RequestBody loanStatementRequestDto: LoanStatementRequestDto)
    : ResponseEntity<List<LoanOfferDto>> = ResponseEntity.ok().body(prescoringService.calculateLoanOffers(loanStatementRequestDto))


    @PostMapping("/calc")
    fun calculationTotalParams(@RequestBody scoringDataDto: ScoringDataDto)
    : ResponseEntity<CreditDto> = ResponseEntity.ok().body(scoringService.calculateCreditDto(scoringDataDto))
}