package com.bankprototype.calculator.rule.personal

import com.bankprototype.calculator.exception.BadScoringInfoException
import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class TotalWorkExperienceRateRule : RateRule {
    @Value("\${minimalTotalWorkExperience}")
    private val minimalTotalWorkExperience: Int? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        if (scoringDataDTO.employment.workExperienceTotal < minimalTotalWorkExperience!!) {
            throw BadScoringInfoException("The total user experience is less than 12 months")
        }

        return rate
    }
}