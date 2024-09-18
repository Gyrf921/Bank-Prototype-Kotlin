package com.bankprototype.deal.service.db

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.dao.enumforobject.ChangeType
import com.bankprototype.deal.web.dto.LoanOfferDto
import org.springframework.stereotype.Service
import java.util.*

@Service
interface StatementService {

    fun saveStatementFromClient(client: Client): Statement

    fun setApplicationOffer(loanOfferDto: LoanOfferDto)

    fun changeApplicationStatus(statementId: UUID, applicationStatus: ApplicationStatus, changeType: ChangeType = ChangeType.AUTOMATIC)
}