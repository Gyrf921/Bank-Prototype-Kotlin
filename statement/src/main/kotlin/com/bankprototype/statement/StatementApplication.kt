package com.bankprototype.statement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class StatementApplication

fun main(args: Array<String>) {
	runApplication<StatementApplication>(*args)
}
