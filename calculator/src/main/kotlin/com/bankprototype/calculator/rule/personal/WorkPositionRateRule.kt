package com.bankprototype.calculator.rule.personal

import com.bankprototype.calculator.rule.RateRule
import com.bankprototype.calculator.web.dto.ScoringDataDto
import com.bankprototype.calculator.web.dto.enumfordto.Position.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class WorkPositionRateRule : RateRule {
    @Value("\${workPositionRateRuleWORKER}")
    private val workPositionRateRuleWORKER: Double? = null

    @Value("\${workPositionRateRuleMIDDLEMANAGER}")
    private val workPositionRateRuleMIDDLEMANAGER: Double? = null

    @Value("\${workPositionRateRuleTOPMANAGER}")
    private val workPositionRateRuleTOPMANAGER: Double? = null

    @Value("\${workPositionRateRuleOWNER}")
    private val workPositionRateRuleOWNER: Double? = null

    override fun getRate(scoringDataDTO: ScoringDataDto, rate: BigDecimal): BigDecimal {

        val customRate = when (scoringDataDTO.employment.position) {
            WORKER -> rate.subtract(
                BigDecimal.valueOf(
                    workPositionRateRuleWORKER!!
                )
            )
            MIDDLE_MANAGER -> rate.subtract(BigDecimal.valueOf(workPositionRateRuleMIDDLEMANAGER!!))
            TOP_MANAGER -> rate.subtract(BigDecimal.valueOf(workPositionRateRuleTOPMANAGER!!))
        }

        return customRate
    }
}