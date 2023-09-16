package com.knubisoft.application.rabbitmq;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RabbitMessageSender {
    private final RabbitProducer rabbitProducer;

    public RabbitMessageSender(final RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    public void sendMessages() {
        rabbitProducer.sendMessage("Hello, RabbitMQ!");
    }

    public void sendCustomMessage(final String message) {
        rabbitProducer.sendMessage(Objects.requireNonNull(message));
    }
}
