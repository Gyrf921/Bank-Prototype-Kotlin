package com.bankprototype.deal.web.dto

import com.bankprototype.deal.dao.enumforobject.*
import java.time.LocalDate


class FinishRegistrationRequestDto() {
    var gender: Gender? = null
    var maritalStatus: MaritalStatus? = null
    var dependentAmount: Int? = null
    var passportIssueDate: LocalDate? = null
    var passportIssueBranch: String? = null
    var employment: EmploymentDto? = null
    var accountNumber: String? = null
}