package com.knubisoft.application.controllers;

import com.knubisoft.application.rabbitmq.RabbitMessageSender;
import com.knubisoft.application.rabbitmq.Receiver;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMessageSender rabbitMessageSender;
    private final Receiver receiver;

    @PostMapping("/send")
    public void sendMessage() {
        rabbitMessageSender.sendMessages();
    }

    @GetMapping("/get")
    public String receiveMessage() throws InterruptedException {
        receiver.getLatch().await();
        return receiver.getLastMessage();
    }
}