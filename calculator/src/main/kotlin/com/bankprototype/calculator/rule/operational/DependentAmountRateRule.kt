package com.bankprototype.calculator.rule.operational

import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class DependentAmountRateRule : RateRule {

    @Value("\${dependentAmountRateRule}")
    private val dependentAmountRateRule: Double? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal
    {
        if (scoringDataDTO.dependentAmount > 1)
            return rate.add(BigDecimal.valueOf(dependentAmountRateRule!!))
        return rate
    }

}