package com.bankprototype.deal


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
//@EnableFeignClients(clients = [CalculatorFeignClient::class])
@EnableFeignClients
class DealApplication

fun main(args: Array<String>) {
	runApplication<DealApplication>(*args)
}
