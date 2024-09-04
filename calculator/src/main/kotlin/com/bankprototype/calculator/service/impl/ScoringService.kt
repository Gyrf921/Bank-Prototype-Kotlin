package com.bankprototype.calculator.service.impl

import com.bankprototype.calculator.rule.RateRuleEngine
import com.bankprototype.calculator.service.factory.CreditFactory
import com.bankprototype.calculator.web.dto.CreditDto
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*


@Service
class ScoringService @Autowired constructor(
    private val creditFactory: CreditFactory,
    private val rateEngine: RateRuleEngine
    ) {

    @Value("\${loanRate}")
    var loanRate: BigDecimal = BigDecimal("0.0")

    @Value("\${priceOfInsurance}")
    var priceOfInsurance: BigDecimal = BigDecimal("0.0")

    fun calculateCreditDto(scoringDataDto: ScoringDataDto): CreditDto{

        var creditRate: BigDecimal = rateEngine.getRate(scoringDataDto, loanRate)

        // if (creditRate.compareTo(BigDecimal.ZERO) <= 0) {
        if (creditRate <= BigDecimal.ZERO)
            creditRate = BigDecimal.ONE

        if (scoringDataDto.isInsuranceEnabled)
            scoringDataDto.amount += priceOfInsurance

        return creditFactory.createCredit(scoringDataDto, creditRate)
    }

}