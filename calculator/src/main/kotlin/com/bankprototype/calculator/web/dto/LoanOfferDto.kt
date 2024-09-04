package com.bankprototype.calculator.web.dto

import java.util.UUID;
import java.math.BigDecimal

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