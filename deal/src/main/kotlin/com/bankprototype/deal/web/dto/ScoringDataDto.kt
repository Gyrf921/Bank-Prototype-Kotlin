package com.bankprototype.deal.web.dto


import com.bankprototype.deal.dao.enumforobject.*
import java.math.BigDecimal
import java.time.LocalDate

class ScoringDataDto {
    var amount: BigDecimal?= null
    var termInMonth: Int?= null
    var firstName: String?= null
    var lastName: String?= null
    var middleName: String?= null
    var gender: Gender?= null
    var birthdate: LocalDate ?= null
    var passportSeries: String ?= null
    var passportNumber: String ?= null
    var passportIssueDate: LocalDate ?= null
    var passportIssueBranch: String ?= null
    var maritalStatus: MaritalStatus ?= null
    var dependentAmount: Int ?= null
    var employment: EmploymentDto ?= null
    var accountNumber: String ?= null
    var isInsuranceEnabled: Boolean ?= null
    var isSalaryClient: Boolean ?= null
}
