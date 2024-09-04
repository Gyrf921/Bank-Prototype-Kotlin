package com.bankprototype.calculator.web.dto

import com.bankprototype.calculator.web.dto.enumfordto.EmploymentStatus
import com.bankprototype.calculator.web.dto.enumfordto.Position
import java.math.BigDecimal

data class EmploymentDto(
    val employmentStatus: EmploymentStatus,
    val employerINN: String,
    val salary: BigDecimal,
    val position: Position,
    val workExperienceTotal: Int,
    val workExperienceCurrent: Int
)

/*




*/