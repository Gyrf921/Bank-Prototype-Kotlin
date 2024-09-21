package com.bankprototype.statement.web.feign

import com.bankprototype.statement.web.dto.LoanOfferDto
import com.bankprototype.statement.web.dto.LoanStatementRequestDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(value = "deal", url = "http://localhost:8081/deal")
interface DealFeignClient {

    @PostMapping("/statement")
    fun calculatePossibleLoanTerms(@RequestBody loanStatementRequestDto: LoanStatementRequestDto)
            : ResponseEntity<List<LoanOfferDto>>

    @PostMapping("/offer/select")
    fun selectOneOfOffers(@RequestBody loanOfferDto: LoanOfferDto)

}