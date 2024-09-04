package com.bankprototype.calculator.web.dto

import java.math.BigDecimal
import java.time.LocalDate

class PaymentScheduleElementDto() {
    var number: Int? = null
    var date: LocalDate? = null
    var totalPayment: BigDecimal? = null
    var interestPayment: BigDecimal? = null
    var debtPayment: BigDecimal? = null
    var remainingDebt: BigDecimal? = null
}