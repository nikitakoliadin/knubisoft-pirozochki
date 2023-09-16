package com.knubisoft.rabbit_consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitConsumerApplication {
    public static void main(final String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
    }
}
