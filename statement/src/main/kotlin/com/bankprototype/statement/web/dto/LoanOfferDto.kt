package com.bankprototype.statement.web.dto

import java.math.BigDecimal
import java.util.*

class LoanOfferDto(){
    var statementId: UUID? = null
    var requestedAmount: BigDecimal? = null
    var totalAmount: BigDecimal? = null
    var termInMonth: Int? = null
    var monthlyPayment: BigDecimal? = null
    var rate: BigDecimal? = null
    var isInsuranceEnabled: Boolean? = null
    var isSalaryClient: Boolean? = null
}