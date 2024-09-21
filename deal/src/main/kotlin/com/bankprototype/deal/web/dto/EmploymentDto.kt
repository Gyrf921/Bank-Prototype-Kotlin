package com.bankprototype.deal.web.dto


import com.bankprototype.deal.dao.enumforobject.*
import java.math.BigDecimal

data class EmploymentDto(
    val employmentStatus: EmploymentStatus,
    val employerINN: String,
    val salary: BigDecimal,
    val position: Position,
    val workExperienceTotal: Int,
    val workExperienceCurrent: Int
)
