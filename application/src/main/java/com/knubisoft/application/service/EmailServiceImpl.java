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
    private static final String MAIL_SENT_SUCCESS = "Mail Sent Successfully";
    private static final String ERROR_SENDING_MAIL = "Error while sending mail";

    @Override
    public String sendEmail(final EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            prepareMimeMessage(emailDetails, mimeMessage);
            javaMailSender.send(mimeMessage);
            log.info(MAIL_SENT_SUCCESS);
            return MAIL_SENT_SUCCESS;
        } catch (MessagingException e) {
            log.info(ERROR_SENDING_MAIL + " :\n" + e.getMessage());
            return ERROR_SENDING_MAIL;
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
}
