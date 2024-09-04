package com.bankprototype.calculator.rule.personal

import com.bankprototype.calculator.exception.BadScoringInfoException
import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import com.bankprototype.calculator.web.dto.enumfordto.EmploymentStatus.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class EmploymentStatusRateRule : RateRule {
    @Value("\${employmentStatusRateRuleBUSINESSOWNER}")
    private val employmentStatusRateRuleBUSINESSOWNER: Double? = null

    @Value("\${employmentStatusRateRuleEMPLOYED}")
    private val employmentStatusRateRuleEMPLOYED: Double? = null

    @Value("\${employmentStatusRateRuleSELFEMPLOYED}")
    private val employmentStatusRateRuleSELFEMPLOYED: Double? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        var customRate = rate

        customRate = when (scoringDataDTO.employment.employmentStatus) {
            BUSINESS_OWNER -> rate.add(
                BigDecimal.valueOf(
                    employmentStatusRateRuleBUSINESSOWNER!!
                )
            )
            EMPLOYED -> rate.add(BigDecimal.valueOf(employmentStatusRateRuleEMPLOYED!!))
            UNEMPLOYED -> {
                throw BadScoringInfoException("The user is unemployed")
            }
        }

        return customRate
    }
}