package com.bankprototype.deal.service.db

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Credit
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import org.springframework.stereotype.Service

@Service
interface CreditService {
    fun saveCreditFromScoringData(frrDto: FinishRegistrationRequestDto, statement: Statement) : Credit
}