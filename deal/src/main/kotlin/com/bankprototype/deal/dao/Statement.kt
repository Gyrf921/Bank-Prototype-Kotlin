package com.bankprototype.deal.dao

import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.dao.jsonb.StatusHistory
import com.bankprototype.deal.web.dto.LoanOfferDto
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.Type
import org.hibernate.annotations.UuidGenerator
import org.hibernate.type.SqlTypes
import java.sql.Timestamp
import java.util.*


@Entity
@Table(name = "statement")
class Statement{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    @Column(name = "statement_id")
    var statementId: UUID? = null

    @OneToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null

    @OneToOne
    @JoinColumn(name = "credit_id")
    var credit: Credit? = null

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    var applicationStatus: ApplicationStatus? = null

    @Column(name = "creation_date")
    var creationDate: Timestamp? = null

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "applied_offer", columnDefinition = "json")
    var applicationOffer: LoanOfferDto? = null

    @Column(name = "sign_date")
    var signDate: Timestamp? = null

    @Column(name = "ses_code")
    var sesCode: String? = null

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "status_history")
    var statusHistory: List<StatusHistory>? = null
}