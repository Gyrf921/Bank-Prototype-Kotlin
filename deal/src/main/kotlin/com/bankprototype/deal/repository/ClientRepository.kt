package com.bankprototype.deal.repository

import com.bankprototype.deal.dao.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClientRepository : JpaRepository <Client, UUID>{
}