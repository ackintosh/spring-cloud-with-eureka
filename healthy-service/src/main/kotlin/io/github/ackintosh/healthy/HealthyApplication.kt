package io.github.ackintosh.healthy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HealthyApplication

fun main(args: Array<String>) {
	runApplication<HealthyApplication>(*args)
}

@RestController
class Controller {
	@GetMapping("/")
	fun demo() = "healthy service!"
}
