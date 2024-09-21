package com.bankprototype.deal.service.db.impl

import com.bankprototype.deal.dao.Client
import com.bankprototype.deal.mapper.ClientMapper
import com.bankprototype.deal.repository.ClientRepository
import com.bankprototype.deal.service.db.ClientService
import com.bankprototype.deal.web.dto.FinishRegistrationRequestDto
import com.bankprototype.deal.web.dto.LoanStatementRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl @Autowired constructor(
    private val clientMapper: ClientMapper,
    private val clientRepository: ClientRepository
): ClientService {

    override fun saveClientFromLoanStatementRequest(loanStatementRequestDto: LoanStatementRequestDto): Client
    = clientRepository.save(
           clientMapper.loanStatementRequestDtoToClient(loanStatementRequestDto))

    override fun updateClientFromFinishRegistrationDto(client: Client, frrDto: FinishRegistrationRequestDto): Client
    = clientMapper.finishRegistrationDtoUpdateClient(client, frrDto)


    override fun saveClient(client: Client): Client
    = clientRepository.save(client)



}