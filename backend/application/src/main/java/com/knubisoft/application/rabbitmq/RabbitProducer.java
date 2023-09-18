package com.knubisoft.application.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitProducer {

    private static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";
    private static final String ROUTING_KEY = "foo.bar.baz";
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(final String message) {
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, message);
        log.info("Sent <" + message + ">");
    }
}
