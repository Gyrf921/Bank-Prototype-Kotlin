package com.bankprototype.calculator.rule.operational

import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import com.bankprototype.calculator.web.dto.enumfordto.Gender.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period


@Component
class GenderRateRule : RateRule{

    @Value("\${genderRateRuleMale}")
    private val genderRateRuleMale: BigDecimal = BigDecimal("0")

    @Value("\${genderRateRuleFEMALE}")
    private val genderRateRuleFEMALE: BigDecimal = BigDecimal("0")

    @Value("\${genderRateRuleNOTBINARY}")
    private val genderRateRuleNOTBINARY: BigDecimal = BigDecimal("0")

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {
        val age: Int = Period.between(scoringDataDTO.birthdate, LocalDate.now()).years
        var customRate = rate
        when (scoringDataDTO.gender) {
            MALE -> if (age in 30..55) {
                customRate = rate - genderRateRuleMale
            }

            FEMALE -> if (age in 35..60) {
                customRate = rate.minus(genderRateRuleFEMALE)
            }

            NOT_BINARY -> customRate = rate.add(genderRateRuleNOTBINARY)
        }

        return customRate
    }

}