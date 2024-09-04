package com.bankprototype.calculator.rule.personal

import com.bankprototype.calculator.exception.BadScoringInfoException
import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class CurrentWorkExperienceRateRule : RateRule {
    @Value("\${minimalCurrentWorkExperience}")
    private val minimalCurrentWorkExperience: Int? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        if (scoringDataDTO.employment.workExperienceCurrent < minimalCurrentWorkExperience!!) {
            throw BadScoringInfoException("The current user experience is less than 3 months")
        }

        return rate
    }
}