package com.knubisoft.application;

import com.knubisoft.application.entity.EmailDetails;
import com.knubisoft.application.service.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class EmailServiceImplTest {
    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private MimeMessage mimeMessage;

    @InjectMocks
    private EmailServiceImpl emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendEmail_Success() throws MessagingException {
        // Arrange
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("recipient@example.com");
        emailDetails.setSubject("Test Subject");
        emailDetails.setMsgBody("Test Message Body");
        String result = emailService.sendEmail(emailDetails);

        assertEquals("Mail Sent Successfully", result);
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send(mimeMessage);
    }
}
