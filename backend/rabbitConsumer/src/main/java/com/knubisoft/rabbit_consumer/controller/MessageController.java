package com.knubisoft.rabbit_consumer.controller;


import com.knubisoft.rabbit_consumer.rabbitmq.Receiver;
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
