package com.knubisoft.application;

import com.knubisoft.application.rabbitmq.RabbitMessageSender;
import com.knubisoft.application.rabbitmq.Receiver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
public class RabbitMQTest {

    @Autowired
    private RabbitMessageSender rabbitMessageSender;

    @Autowired
    private Receiver receiver;

    @Test
    public void testRabbitMQMessaging() throws InterruptedException {
        rabbitMessageSender.sendMessages();
        // Wait until a message is received
        receiver.getLatch().await();
        // Retrieve the received message
        String receivedMessage = receiver.getLastMessage();
        // Assert the received message content
        assertEquals("Hello, RabbitMQ!", receivedMessage);
    }
}