package com.knubisoft.rabbit_consumer.rabbitmq;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
@Component
public class Receiver {

    @Getter
    private final CountDownLatch latch = new CountDownLatch(1);
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    @RabbitListener
    public void receiveMessage(final String message) {
        log.info("Received <" + message + ">");
        latch.countDown();
        messageQueue.add(message);
    }

    public String getLastMessage() {
        return messageQueue.poll();
    }
}
