package com.bankprototype.calculator.service.factory

import com.bankprototype.calculator.service.impl.COUNT_MONTH_OF_YEAR
import com.bankprototype.calculator.service.impl.CalculationServiceImpl
import com.bankprototype.calculator.web.dto.LoanOfferDto
import com.bankprototype.calculator.web.dto.LoanStatementRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class LoanOfferFactory @Autowired constructor(private val calculationService: CalculationServiceImpl){

    @Value("\${loanRate}")
    var loanRate: Double = 0.0

    @Value("\${ratioOfInsuranceEnabled}")
    var ratioOfInsuranceEnabled: BigDecimal = BigDecimal("0.0")

    @Value("\${ratioOfSalaryClient}")
    var ratioOfSalaryClient: BigDecimal = BigDecimal("0.0")

    @Value("\${priceOfInsurance}")
    var priceOfInsurance: BigDecimal = BigDecimal("0.0")

    fun createLoanOffer(loanStatementRequestDto: LoanStatementRequestDto,
                            isInsuranceEnabled: Boolean = false, isSalaryClient: Boolean = false): LoanOfferDto{
        val loanOffer = LoanOfferDto()

        loanOffer.statementId = UUID.randomUUID()
        loanOffer.requestedAmount = loanStatementRequestDto.amount
        //total amount
        loanOffer.termInMonth = loanStatementRequestDto.termInMonth
        //mountly payment
        loanOffer.rate = BigDecimal(loanRate)
        loanOffer.isInsuranceEnabled = isInsuranceEnabled
        loanOffer.isSalaryClient = isSalaryClient

        if(isSalaryClient) {
            loanOffer.rate = loanOffer.rate!!.minus(ratioOfSalaryClient)
        }
        if(isInsuranceEnabled) {
            loanOffer.requestedAmount = loanOffer.requestedAmount!! + priceOfInsurance
            loanOffer.rate = loanOffer.rate!!.minus(ratioOfInsuranceEnabled)
        }

        loanOffer.monthlyPayment = calculationService.calculationMonthlyPayment(loanOffer.requestedAmount!!, loanOffer.termInMonth!!, loanOffer.rate!!)
        loanOffer.totalAmount = calculationService.calculationTotalAmount(loanOffer.monthlyPayment!!, loanOffer.termInMonth!!)

        return loanOffer
    }
}