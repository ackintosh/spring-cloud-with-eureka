package io.github.ackintosh.faultyservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FaultyServiceApplication

fun main(args: Array<String>) {
	runApplication<FaultyServiceApplication>(*args)
}

@RestController
class Controller {
	@GetMapping("/")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	fun demo() = "faulty service!"
}
