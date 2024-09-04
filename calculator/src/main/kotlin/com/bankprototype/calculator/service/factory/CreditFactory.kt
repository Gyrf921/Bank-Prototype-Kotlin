package com.bankprototype.calculator.service.factory

import com.bankprototype.calculator.service.impl.CalculationServiceImpl
import com.bankprototype.calculator.web.dto.CreditDto
import com.bankprototype.calculator.web.dto.ScoringDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class CreditFactory @Autowired constructor(
    private val calculationService: CalculationServiceImpl
) {
    fun createCredit(scoringDataDTO: ScoringDataDto, creditRate: BigDecimal): CreditDto {
        val creditDto = CreditDto()

        creditDto.amount = scoringDataDTO.amount
        creditDto.termInMonth = scoringDataDTO.termInMonth
        creditDto.monthlyPayment = calculationService.calculationMonthlyPayment(scoringDataDTO.amount, scoringDataDTO.termInMonth, creditRate)
        creditDto.rate = creditRate
        creditDto.psk = calculationService.calculationTotalAmount(creditDto.monthlyPayment!!, scoringDataDTO.termInMonth)
        creditDto.isInsuranceEnabled = scoringDataDTO.isInsuranceEnabled
        creditDto.isSalaryClient = scoringDataDTO.isSalaryClient
        creditDto.paymentSchedule = calculationService.calculationPaymentSchedules(creditDto.psk!!, creditDto.monthlyPayment!!, creditRate)

        return creditDto
    }


}