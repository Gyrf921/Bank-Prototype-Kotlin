package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.ScoringDataDto
import org.springframework.stereotype.Component


@Component
class ScoringMapper {

    fun finishRegistrationRequestDtoToScoringDataDto(
        frrDto: FinishRegistrationRequestDto,
        statement: Statement
    ): ScoringDataDto{

        var scoringDataDto = ScoringDataDto()

        scoringDataDto.amount = statement.applicationOffer!!.totalAmount
        scoringDataDto.termInMonth = statement.applicationOffer!!.termInMonth
        scoringDataDto.firstName = statement.client!!.firstName
        scoringDataDto.lastName = statement.client!!.lastName
        scoringDataDto.middleName = statement.client!!.middleName
        scoringDataDto.gender = frrDto.gender
        scoringDataDto.birthdate = statement.client!!.birthdate
        scoringDataDto.passportSeries = statement.client!!.passport!!.series
        scoringDataDto.passportNumber = statement.client!!.passport!!.number
        scoringDataDto.passportIssueDate = frrDto.passportIssueDate
        scoringDataDto.passportIssueBranch = frrDto.passportIssueBranch
        scoringDataDto.maritalStatus = frrDto.maritalStatus
        scoringDataDto.dependentAmount = frrDto.dependentAmount
        scoringDataDto.employment = frrDto.employment
        scoringDataDto.accountNumber = frrDto.accountNumber
        scoringDataDto.isInsuranceEnabled = statement.applicationOffer!!.isInsuranceEnabled
        scoringDataDto.isSalaryClient = statement.applicationOffer!!.isSalaryClient

        return scoringDataDto
        //Mapping

        return ScoringDataDto()
    }
}
