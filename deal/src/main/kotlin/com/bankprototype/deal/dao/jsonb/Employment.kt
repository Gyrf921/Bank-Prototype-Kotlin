package com.bankprototype.deal.dao.jsonb

import com.bankprototype.deal.dao.enumforobject.*
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

data class Employment(
    @field: Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var employmentId: Long,
    private val status: EmploymentStatus,
    private val employerInn: String,
    private val salary: BigDecimal,
    private val position: Position,
    private val workExperienceTotal: Int,
    private val workExperienceCurrent: Int?,
)
