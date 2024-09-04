package com.bankprototype.calculator.rule

import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.math.BigDecimal


@Component
@PropertySource("classpath:scoringConfig.properties")
class RateRuleEngine @Autowired constructor(private val rateRules: List<RateRule>): RateRule{

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {
        var customRate = rate

        for (rule in rateRules) {
            customRate = rule.getRate(scoringDataDTO, customRate)
        }

        return customRate
    }

}