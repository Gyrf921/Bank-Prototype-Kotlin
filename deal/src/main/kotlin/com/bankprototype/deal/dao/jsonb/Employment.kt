package com.bankprototype.deal.dao.jsonb

import com.bankprototype.deal.dao.enumforobject.*
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable
import java.math.BigDecimal

class Employment(
    val status: EmploymentStatus,
    val employerInn: String,
    val salary: BigDecimal,
    val position: Position,
    val workExperienceTotal: Int,
    val workExperienceCurrent: Int,
) : Serializable
