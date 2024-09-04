package com.bankprototype.calculator.service

import com.bankprototype.calculator.web.dto.PaymentScheduleElementDto
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface CalculationService {

    fun calculationMonthlyPayment(totalAmount: BigDecimal, term: Int, rate: BigDecimal) : BigDecimal
    fun calculationTotalAmount(monthlyPayment: BigDecimal, countMonth: Int): BigDecimal
    fun calculationPaymentSchedules(monthlyPaymentCalc: BigDecimal, pskCalc: BigDecimal, rate: BigDecimal): List<PaymentScheduleElementDto>
}