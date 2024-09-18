package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Credit
import com.bankprototype.deal.web.dto.CreditDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface CreditMapper {
    fun creditDtoToCredit(creditDto: CreditDto): Credit
}