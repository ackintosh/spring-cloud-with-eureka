package io.github.ackintosh.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

