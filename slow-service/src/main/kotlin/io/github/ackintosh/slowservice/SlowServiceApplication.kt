package io.github.ackintosh.slowservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SlowServiceApplication

fun main(args: Array<String>) {
	runApplication<SlowServiceApplication>(*args)
}

@RestController
class Controller {
	@GetMapping("/")
	fun demo(): String {
		Thread.sleep(10000)
		return "slow service!"
	}
}