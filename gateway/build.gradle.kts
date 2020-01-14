import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "io.github.ackintosh"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "Hoxton.RELEASE"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // *** Gateway ***
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // *** Circuit breaker ***
    // we need to include reactive version of Spring Cloud Circuit Breaker since gateway is started on reactive Netty server.
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")
    // FIXME: here is a workaround for the issue: https://github.com/spring-cloud/spring-cloud-gateway/issues/1442
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix")

    // *** Service discovery ***
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // *** Client-side load balancing ***
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
