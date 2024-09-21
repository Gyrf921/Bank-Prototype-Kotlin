package com.bankprototype.deal.service.db.impl

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.dao.enumforobject.ChangeType
import com.bankprototype.deal.dao.jsonb.StatusHistory
import com.bankprototype.deal.mapper.StatementMapper
import com.bankprototype.deal.mapper.ScoringMapper
import com.bankprototype.deal.repository.StatementRepository
import com.bankprototype.deal.service.db.StatementService
import com.bankprototype.deal.web.dto.LoanOfferDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Service
class StatementServiceImpl @Autowired constructor(
    private val statementRepository: StatementRepository,
    private val statementMapper: StatementMapper,
    private val scoringMapper: ScoringMapper
) : StatementService {


    override fun getStatementById(id: UUID): Statement
        = statementRepository.getReferenceById(id)


    override fun saveStatement(statement: Statement) : Statement
        = statementRepository.save(statement)

    override fun saveStatementFromClient(client: Client): Statement
         = statementRepository.save(statementMapper.createStatementFromClient(client))


    override fun setApplicationOffer(loanOfferDto: LoanOfferDto) {
        var statement = getStatementById(loanOfferDto.statementId!!)
        statement.applicationOffer = loanOfferDto
        changeApplicationStatus(statement, ApplicationStatus.APPROVED)

        saveStatement(statement)
    }

    override fun changeApplicationStatus(statement: Statement, applicationStatus: ApplicationStatus, changeType: ChangeType
    ) {
        statement.applicationStatus = applicationStatus
        statement.statusHistory = statement.statusHistory!!.plus(
            StatusHistory(
                applicationStatus,
                Timestamp.valueOf(LocalDateTime.now()),
                changeType)
        )
    }


}