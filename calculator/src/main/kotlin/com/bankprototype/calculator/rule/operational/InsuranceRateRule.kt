package com.bankprototype.calculator.rule.operational

import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class InsuranceRateRule : RateRule {

    @Value("\${insuranceRateRule}")
    private val insuranceRateRule: Double? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        var customRate = rate
        if (java.lang.Boolean.TRUE == scoringDataDTO.isInsuranceEnabled) {
            customRate = rate.subtract(BigDecimal.valueOf(insuranceRateRule!!))
        }

        return customRate
    }
}