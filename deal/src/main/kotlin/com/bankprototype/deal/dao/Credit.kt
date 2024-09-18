package com.bankprototype.deal.dao

import com.bankprototype.deal.dao.enumforobject.*
import com.bankprototype.deal.web.dto.*
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.Type
import org.hibernate.annotations.UuidGenerator
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "credit")
class Credit(creditId: UUID, amount: BigDecimal, term: Int, monthlyPayment: BigDecimal, rate: BigDecimal, psk: BigDecimal, paymentSchedule: MutableList<PaymentScheduleElementDto>, insuranceEnable: Boolean, salaryClient: Boolean, creditStatus: CreditStatus) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    @Column(name = "credit_id")
    var creditId: UUID? = null

    @Column(name = "amount")
    var amount: BigDecimal? = null

    @Column(name = "term")
    var term: Int? = null

    @Column(name = "monthly_payment")
    var monthlyPayment: BigDecimal? = null

    @Column(name = "rate")
    var rate: BigDecimal? = null

    @Column(name = "psk")
    var psk: BigDecimal? = null

    @field:  JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "payment_schedule", columnDefinition = "json")
    var paymentSchedule: List<PaymentScheduleElementDto>? = null

    @Column(name = "insurance_enable")
    var insuranceEnable: Boolean? = null

    @Column(name = "salary_client")
    var salaryClient: Boolean? = null

    @Column(name = "credit_status")
    @Enumerated(EnumType.STRING)
    var creditStatus: CreditStatus? = null
}