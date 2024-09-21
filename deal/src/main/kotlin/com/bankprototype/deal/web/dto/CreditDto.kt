package com.bankprototype.deal.web.dto

import java.math.BigDecimal

class CreditDto (){
    var amount: BigDecimal? = null
    var termInMonth: Int? = null
    var monthlyPayment: BigDecimal? = null
    var rate: BigDecimal? = null
    var psk: BigDecimal? = null
    var isInsuranceEnabled: Boolean? = null
    var isSalaryClient: Boolean? = null
    var paymentSchedule: List<PaymentScheduleElementDto>? = null
}