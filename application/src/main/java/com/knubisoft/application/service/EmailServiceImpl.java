package com.knubisoft.application.service;

import com.knubisoft.application.entity.EmailDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    private static final String MAIL_SENT_SUCCESSFULLY = "Mail Sent Successfully...";
    private static final String ERROR_WHILE_SENDING_MAIL = "Error while sending mail";

    @Override
    public String sendEmail(final EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            prepareMimeMessage(emailDetails, mimeMessage);
            return sendEmail(mimeMessage);
        } catch (MessagingException e) {
            return ERROR_WHILE_SENDING_MAIL;
        }
    }

    private void prepareMimeMessage(final EmailDetails emailDetails,
                                    final MimeMessage mimeMessage) throws MessagingException {
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(emailDetails.getRecipient());
        mimeMessageHelper.setText(emailDetails.getMsgBody());
        mimeMessageHelper.setSubject(emailDetails.getSubject());
        if (nonNull(emailDetails.getAttachment())) {
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
        }
    }

    private String sendEmail(final MimeMessage mailMessage) {
        try {
            javaMailSender.send(mailMessage);
            return MAIL_SENT_SUCCESSFULLY;
        } catch (Exception e) {
            log.info("Error while sending mail :\n" + e.getMessage());
            return ERROR_WHILE_SENDING_MAIL;
        }
    }
}
