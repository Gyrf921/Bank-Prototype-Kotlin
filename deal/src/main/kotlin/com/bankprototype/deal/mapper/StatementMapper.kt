package com.bankprototype.deal.mapper

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Statement
import com.bankprototype.deal.dao.enumforobject.ApplicationStatus
import com.bankprototype.deal.dao.enumforobject.ChangeType
import com.bankprototype.deal.dao.jsonb.StatusHistory
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.LocalDateTime

@Component
class StatementMapper {

    fun createStatementFromClient(client: Client): Statement {
        val statement = Statement()

        statement.client = client
        statement.applicationStatus = ApplicationStatus.PREAPPROVAL
        statement.creationDate = Timestamp.valueOf(LocalDateTime.now())

        statement.statusHistory = mutableListOf(
            StatusHistory(
                ApplicationStatus.PREAPPROVAL,
                Timestamp.valueOf(LocalDateTime.now()),
                ChangeType.AUTOMATIC)
        )
        return statement
    }

}