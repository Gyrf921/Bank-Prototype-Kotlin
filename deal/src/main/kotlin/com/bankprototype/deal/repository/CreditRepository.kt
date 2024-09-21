package com.bankprototype.deal.repository

import com.bankprototype.deal.dao.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository  : JpaRepository<Credit, UUID> {
}