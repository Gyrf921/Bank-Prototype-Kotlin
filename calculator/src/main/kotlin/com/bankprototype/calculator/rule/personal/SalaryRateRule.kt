package com.bankprototype.calculator.rule.personal

import com.bankprototype.calculator.exception.BadScoringInfoException
import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class SalaryRateRule : RateRule {
    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        val twentySalary: BigDecimal = scoringDataDTO.employment.salary.multiply(BigDecimal.valueOf(20))

        if (twentySalary.compareTo(scoringDataDTO.amount) < 0) {

            throw BadScoringInfoException("The user asks for an amount of 20 or more in excess of his salary")
        }

        return rate
    }
}