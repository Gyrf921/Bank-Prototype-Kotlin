package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.jsonb.Employment
import com.bankprototype.deal.dao.jsonb.Passport
import com.bankprototype.deal.web.dto.EmploymentDto
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.springframework.stereotype.Component


@Component
class ClientMapper {
    fun loanStatementRequestDtoToClient(lsrDto: LoanStatementRequestDto): Client{
        val client = Client()
        val passport = Passport()

        passport.number = lsrDto.passportNumber
        passport.series = lsrDto.passportSeries

        client.lastName = lsrDto.lastName
        client.firstName = lsrDto.firstName
        client.middleName = lsrDto.middleName
        client.birthdate = lsrDto.birthdate
        client.email = lsrDto.email
        client.passport = passport

        return client
    }

    fun finishRegistrationDtoUpdateClient(client: Client, frrDto: FinishRegistrationRequestDto) : Client{
        var passport = client.passport!!
        passport.issueDate = frrDto.passportIssueDate
        passport.issueBranch = frrDto.passportIssueBranch

        client.gender = frrDto.gender
        client.maritalStatus = frrDto.maritalStatus
        client.dependentAmount = frrDto.dependentAmount
        client.passport = passport
        client.employment = employmentDtoToEmployment(frrDto.employment!!)
        client.account = frrDto.accountNumber

        return client
    }


    private fun employmentDtoToEmployment(employmentDto: EmploymentDto): Employment
        = Employment(
            employmentDto.employmentStatus,
            employmentDto.employerINN,
            employmentDto.salary,
            employmentDto.position,
            employmentDto.workExperienceTotal,
            employmentDto.workExperienceCurrent
        )

}

