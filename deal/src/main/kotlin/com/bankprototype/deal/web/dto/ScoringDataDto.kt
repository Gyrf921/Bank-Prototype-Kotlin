package com.bankprototype.deal.web.dto


import com.bankprototype.deal.dao.enumforobject.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate

data class ScoringDataDto(
    var amount: BigDecimal,
    val termInMonth: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val gender: Gender,
    @field: NotNull
    @field: DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @field: Past(message = "birthday can't be after current date")
    val birthdate: LocalDate,
    val passportSeries: String,
    val passportNumber: String,
    val passportIssueDate: LocalDate,
    val passportIssueBranch: String,
    val maritalStatus: MaritalStatus,
    val dependentAmount: Int,
    val employment: EmploymentDto,
    val accountNumber: String,
    val isInsuranceEnabled: Boolean,
    val isSalaryClient: Boolean
)
