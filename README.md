# spring-cloud-with-eureka

- Spring Boot (Kotlin)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Spring Cloud Circuit Breaker](https://spring.io/projects/spring-cloud-circuitbreaker) ([Resilience4j](https://github.com/resilience4j/resilience4j))
- [Spring Cloud LoadBalancer](https://spring.io/guides/gs/spring-cloud-loadbalancer/)
- [Eureka](https://github.com/Netflix/eureka)

:tipping_hand_man: Raising the memory limit of Docker engine on your host machine may help you if you have build errors while `docker-compose up`.

```sh
$ docker-compose up

# Eureka dashboard
$ open http://localhost:9010/

# GET healthy service via gateway
$ open http://localhost:9000/healthy/
# GET faulty service via gateway
$ open http://localhost:9000/faulty/
# GET slow service via gateway
$ open http://localhost:9000/slow/
```

![image](https://user-images.githubusercontent.com/1885716/72339178-30222980-3709-11ea-93d7-f725c112827e.png)
