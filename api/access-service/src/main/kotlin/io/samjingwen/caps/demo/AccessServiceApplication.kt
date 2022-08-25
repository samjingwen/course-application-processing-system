package io.samjingwen.caps.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class AccessServiceApplication

fun main(args: Array<String>) {
	runApplication<AccessServiceApplication>(*args)
}
