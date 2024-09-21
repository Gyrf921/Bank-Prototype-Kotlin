package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Credit
import com.bankprototype.deal.dao.enumforobject.CreditStatus
import com.bankprototype.deal.web.dto.CreditDto
import org.springframework.stereotype.Component


@Component
class CreditMapper {
    fun creditDtoToCredit(creditDto: CreditDto): Credit{
        var credit = Credit()

        credit.amount = creditDto.amount
        credit.term = creditDto.termInMonth
        credit.monthlyPayment = creditDto.monthlyPayment
        credit.rate = creditDto.rate
        credit.psk = creditDto.psk
        credit.paymentSchedule = creditDto.paymentSchedule
        credit.insuranceEnable = creditDto.isInsuranceEnabled
        credit.salaryClient = creditDto.isSalaryClient
        credit.creditStatus = CreditStatus.CALCULATED

        return credit
    }
}