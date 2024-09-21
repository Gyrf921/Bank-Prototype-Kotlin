package com.bankprototype.deal.dao.jsonb

import com.bankprototype.deal.dao.enumforobject.*
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime

class StatusHistory (
     val status: ApplicationStatus,
     val time: Timestamp,
     val changeType: ChangeType,
) : Serializable