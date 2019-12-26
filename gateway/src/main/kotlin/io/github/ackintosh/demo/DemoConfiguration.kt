package io.github.ackintosh.demo

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.timelimiter.TimeLimiterConfig
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder
import org.springframework.cloud.client.circuitbreaker.Customizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class DemoConfiguration {
    @Bean
    fun defaultCustomizer(): Customizer<ReactiveResilience4JCircuitBreakerFactory> =
            Customizer { factory ->
                factory.configureDefault { id ->
                    Resilience4JConfigBuilder(id)
                            .circuitBreakerConfig(
                                    CircuitBreakerConfig.custom()
                                            .slidingWindow(3, 1, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                                            .slowCallDurationThreshold(Duration.ofMillis(100))
                                            .slowCallRateThreshold(3F)
                                            .build()
                            )
                            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(200)).build())
                            .build()
                }
            }
}