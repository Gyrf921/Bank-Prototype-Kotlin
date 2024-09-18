package com.bankprototype.deal.dao.jsonb

import com.bankprototype.deal.dao.enumforobject.*
import java.sql.Timestamp
import java.time.LocalDateTime

class StatusHistory (
    private var status: ApplicationStatus,
    private val time: Timestamp,
    private val changeType: ChangeType,
)