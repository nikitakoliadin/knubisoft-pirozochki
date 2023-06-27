package com.knubisoft.application.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class RabbitMessageSender {
    private final RabbitProducer rabbitProducer;

    public RabbitMessageSender(RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    public void sendMessages() {
        rabbitProducer.sendMessage("Hello, RabbitMQ!");
        rabbitProducer.sendMessage("Another message");
    }
}
