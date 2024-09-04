package com.bankprototype.calculator.service.impl

import com.bankprototype.calculator.service.CalculationService
import com.bankprototype.calculator.web.dto.LoanOfferDto
import com.bankprototype.calculator.web.dto.PaymentScheduleElementDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*

const val COUNT_MONTH_OF_YEAR = 12


@Service
class CalculationServiceImpl : CalculationService {

    override fun calculationMonthlyPayment(totalAmount: BigDecimal, termInMonth: Int, rate: BigDecimal) : BigDecimal{
        val monthlyInterestRate: BigDecimal = calculationMonthlyInterestRate(rate)

        val tempSumForPow = BigDecimal.ONE.add(monthlyInterestRate)
        val temp = tempSumForPow.pow(termInMonth)
        val tempPow = BigDecimal.ONE.divide(temp, temp.scale(), RoundingMode.DOWN)
        val tempForCalc = BigDecimal.ONE.subtract(tempPow)

        val monthlyPaymentAmount = totalAmount.multiply(monthlyInterestRate).divide(tempForCalc, RoundingMode.valueOf(5))

        return monthlyPaymentAmount
    }

    fun calculationMonthlyInterestRate(customLoanRate: BigDecimal): BigDecimal {
        val denominator = BigDecimal.valueOf(100L * COUNT_MONTH_OF_YEAR)
        val scale = BigDecimal("0.00001")
        val monthlyInterestRate = customLoanRate.divide(denominator, scale.scale(), RoundingMode.HALF_EVEN)
        return monthlyInterestRate
    }

    override fun calculationTotalAmount(monthlyPayment: BigDecimal, countMonth: Int): BigDecimal {
        val totalAmount = monthlyPayment.multiply(BigDecimal.valueOf(countMonth.toLong()))
        return totalAmount
    }

    private fun createPaymentScheduleElement(numDate: Int, remainingDebt: BigDecimal, monthlyPayment: BigDecimal,monthRate: BigDecimal): PaymentScheduleElementDto{
        val paymentSchedule = PaymentScheduleElementDto()

        paymentSchedule.number = numDate
        paymentSchedule.date = LocalDate.now().plusMonths(numDate.toLong())
        paymentSchedule.totalPayment = monthlyPayment
        paymentSchedule.interestPayment = remainingDebt * monthRate
        paymentSchedule.debtPayment = monthlyPayment - paymentSchedule.interestPayment!!
        paymentSchedule.remainingDebt = remainingDebt - monthlyPayment

        return paymentSchedule
    }

    override fun calculationPaymentSchedules(pskCalc: BigDecimal, monthlyPaymentCalc: BigDecimal,
                                             rate: BigDecimal): List<PaymentScheduleElementDto> {
        val elementList: MutableList<PaymentScheduleElementDto> = mutableListOf()
        val monthRate = calculationMonthlyInterestRate(rate)
        var remainingDebt = pskCalc

        while (monthlyPaymentCalc <= remainingDebt){
            elementList.add(
                createPaymentScheduleElement(
                    elementList.size + 1,
                    remainingDebt,
                    monthlyPaymentCalc,
                    monthRate)
            )
            remainingDebt -= monthlyPaymentCalc
        }

        return elementList
    }

}