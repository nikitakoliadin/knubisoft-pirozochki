package com.knubisoft.application.rabbitmq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();


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
