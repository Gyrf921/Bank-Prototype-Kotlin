package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.jsonb.Passport
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
interface ClientMapper {
    fun loanStatementRequestDtoToClient(lsrDto: LoanStatementRequestDto): Client
}

/*    fun loanStatementRequestDtoToClient(lsrDto: LoanStatementRequestDto): Client{
        val passport = Passport()
        passport.number = lsrDto.passportNumber
        passport.series = lsrDto.passportSeries
        return Client( null,
            lsrDto.lastName,
            lsrDto.firstName, lsrDto.middleName, lsrDto.birthdate, lsrDto.email, null, null, null,  passport
        , null, null)
    }*/
