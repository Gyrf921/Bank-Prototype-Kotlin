package com.bankprototype.deal.dao


import com.bankprototype.deal.dao.enumforobject.*
import com.bankprototype.deal.dao.jsonb.*
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.annotations.UuidGenerator
import org.hibernate.type.SqlTypes
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "client")
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    @Column(name = "client_id")
    var clientId: UUID? = null

    @Column(name = "last_name", nullable = false)
    var lastName: String? = null

    @Column(name = "first_name", nullable = false)
    var firstName: String? = null

    @Column(name = "middle_name")
    var middleName: String? = null

    @Column(name = "birth_date")
    var birthdate: LocalDate? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    var gender: Gender? = null

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    var maritalStatus: MaritalStatus? = null

    @Column(name = "dependent_amount")
    var dependentAmount: Int? = null

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "passport_id")
    var passport: Passport? = null

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "employment_id")
    var employment: Employment? = null

    @Column(name = "account")
    var account: String? = null
}
