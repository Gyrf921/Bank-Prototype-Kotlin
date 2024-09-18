package com.bankprototype.deal.service.db

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.springframework.stereotype.Service

@Service
interface ClientService {
    fun saveClientFromLoanStatementRequest(loanStatementRequestDto: LoanStatementRequestDto): Client
}