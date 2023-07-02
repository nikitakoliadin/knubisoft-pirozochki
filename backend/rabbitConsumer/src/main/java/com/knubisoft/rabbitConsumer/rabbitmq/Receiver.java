package com.knubisoft.rabbitConsumer.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    @RabbitListener
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
        messageQueue.add(message);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getLastMessage() {
        return messageQueue.poll();
    }
}
