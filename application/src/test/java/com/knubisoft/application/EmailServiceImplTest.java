package com.knubisoft.application;

import com.knubisoft.application.entity.EmailDetails;
import com.knubisoft.application.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
public class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;

    @Test
    void sendEmailSuccess() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("recipient@example.com");
        emailDetails.setSubject("Test Subject");
        emailDetails.setMsgBody("Test Message Body");
        String result = emailService.sendEmail(emailDetails);

        assertEquals("Mail Sent Successfully", result);
    }

    @Test
    void sendEmailFailure() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(""); // Invalid recipient to simulate failure
        emailDetails.setSubject("Test Subject");
        emailDetails.setMsgBody("Test Message Body");
        String result = emailService.sendEmail(emailDetails);

        assertEquals("Error while sending mail", result);
    }
}