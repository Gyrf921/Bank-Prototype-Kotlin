package com.bankprototype.calculator.rule.operational

import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import com.bankprototype.calculator.web.dto.enumfordto.MaritalStatus.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class MaritalStatusRateRule : RateRule {

    @Value("\${maritalStatusRateRuleSINGLE}")
    private val maritalStatusRateRuleSINGLE: Double? = null

    @Value("\${maritalStatusRateRuleMARRIED}")
    private val maritalStatusRateRuleMARRIED: Double? = null

    @Value("\${maritalStatusRateRuleDIVORCED}")
    private val maritalStatusRateRuleDIVORCED: Double? = null

    @Value("\${maritalStatusRateRuleWIDOWWIDOWER}")
    private val maritalStatusRateRuleWIDOWWIDOWER: Double? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        var customRate = rate

        customRate = when (scoringDataDTO.maritalStatus) {
            SINGLE -> rate.subtract(BigDecimal.valueOf(maritalStatusRateRuleSINGLE!!))
            MARRIED -> rate.subtract(BigDecimal.valueOf(maritalStatusRateRuleMARRIED!!))
            DIVORCED -> rate.add(BigDecimal.valueOf(maritalStatusRateRuleDIVORCED!!))
        }

        return customRate
    }
}