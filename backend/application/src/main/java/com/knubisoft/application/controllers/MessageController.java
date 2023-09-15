package com.knubisoft.application.controllers;

import com.knubisoft.application.rabbitmq.RabbitMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMessageSender rabbitMessageSender;

    @PostMapping("/send")
    public void sendMessage() {
        rabbitMessageSender.sendMessages();
    }

    @PostMapping("/sendCustom")
    public void sendCustomMessage(@RequestBody final String customMessage) {
        rabbitMessageSender.sendCustomMessage(customMessage);
    }

}
