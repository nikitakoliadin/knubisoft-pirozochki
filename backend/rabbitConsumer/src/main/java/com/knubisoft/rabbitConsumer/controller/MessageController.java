package com.knubisoft.rabbitConsumer.controller;


import com.knubisoft.rabbitConsumer.rabbitmq.Receiver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final Receiver receiver;

    @GetMapping("/getMessage")
    public String receiveMessage() throws InterruptedException {
        receiver.getLatch().await();
        return receiver.getLastMessage();
    }
}