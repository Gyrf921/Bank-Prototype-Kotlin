package com.bankprototype.statement.web.dto

import jakarta.validation.constraints.*
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate

data class LoanStatementRequestDto (
    @field: NotNull
    @field: DecimalMin("5000")
    val amount: BigDecimal,
    @field: NotNull
    @field: Min(6)
    val termInMonth: Int,

    @field: NotNull
    @field: Pattern(regexp = "^[a-zA-Z]+$", message = "middleName must contain only letters a-z and A-Z")
    val firstName: String,
    @field: NotNull
    @field: Pattern(regexp = "^[a-zA-Z]+$", message = "middleName must contain only letters a-z and A-Z")
    val lastName: String,
    @field: NotNull
    @field: Pattern(regexp = "^[a-zA-Z]+$", message = "middleName must contain only letters a-z and A-Z")
    val middleName: String,

    @field: NotNull
    @field: Email
    val email: String,
    @field: NotNull
    @field: DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @field: Past(message = "birthday can't be after current date")
    val birthdate: LocalDate,

    @field: NotNull
    @field: Pattern(regexp = "^[0-9]+$", message = "passportSeries it is 4 number")
    val passportSeries: String,
    @field: NotNull
    @field: Pattern(regexp = "^[0-9]+$", message = "passportSeries it is 4 number")
    val passportNumber: String
)