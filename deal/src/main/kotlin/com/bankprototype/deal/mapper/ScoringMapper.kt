package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.ScoringDataDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ScoringMapper {
    @Mapping(target = "gender", source = "finishRegistrationRequestDto.gender")
    @Mapping(target = "maritalStatus", source = "finishRegistrationRequestDto.maritalStatus")
    @Mapping(target = "dependentAmount", source = "finishRegistrationRequestDto.dependentAmount")
    @Mapping(target = "employment", source = "finishRegistrationRequestDto.employment")
    fun finishRegistrationRequestDtoToScoringDataDto(
        finishRegistrationRequestDto: FinishRegistrationRequestDto,
        client: Client
    ): ScoringDataDto
}
