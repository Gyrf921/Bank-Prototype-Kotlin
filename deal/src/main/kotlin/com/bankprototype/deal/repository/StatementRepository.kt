package com.bankprototype.deal.repository

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.dao.Statement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StatementRepository : JpaRepository<Statement, UUID> {
}