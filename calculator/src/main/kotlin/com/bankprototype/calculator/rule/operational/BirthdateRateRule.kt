package com.bankprototype.calculator.rule.operational

import com.bankprototype.calculator.exception.BadScoringInfoException
import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period


@Component
class BirthdateRateRule : RateRule {
    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {
        val age: Int = Period.between(scoringDataDTO.birthdate, LocalDate.now()).years

        if (age < 20 || age > 60) {
            throw BadScoringInfoException("The client's age is less than 20 or more than 60 years")
        }
        return rate
    }
}