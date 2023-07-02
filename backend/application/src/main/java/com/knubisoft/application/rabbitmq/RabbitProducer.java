package com.knubisoft.application.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String topicExchangeName = "spring-boot-exchange";
    private final String routingKey = "foo.bar.baz";

    @Autowired
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);
        System.out.println("Sent <" + message + ">");
    }
}
