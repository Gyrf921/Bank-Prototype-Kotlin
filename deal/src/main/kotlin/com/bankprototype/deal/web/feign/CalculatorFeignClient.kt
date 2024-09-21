package com.bankprototype.deal.web.feign

import com.bankprototype.deal.web.dto.CreditDto
import com.bankprototype.deal.web.dto.LoanOfferDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import com.bankprototype.deal.web.dto.ScoringDataDto
import com.bankprototype.deal.web.feign.fallback.CalculatorFeignClientFallbackFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "calculator", url = "http://localhost:8080/calculator")
interface CalculatorFeignClient {

    @PostMapping("/offers")
    fun possibleLoanTerms(@RequestBody loanStatementRequestDto: LoanStatementRequestDto)
            : ResponseEntity<List<LoanOfferDto>>

    @PostMapping("/calc")
    fun calculationTotalParams(@RequestBody scoringDataDto: ScoringDataDto)
            : ResponseEntity<CreditDto>
}
