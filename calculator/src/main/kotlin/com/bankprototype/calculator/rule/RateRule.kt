package com.bankprototype.calculator.rule

import com.bankprototype.calculator.web.dto.ScoringDataDto
import java.math.BigDecimal

interface RateRule {
    fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal
}