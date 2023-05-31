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
import static java.util.Objects.requireNonNull;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    @Value("${attachmentsCapSize}")
    private int attachmentsCapSize;
    private static final String MAIL_SENT_SUCCESS = "Mail Sent Successfully";
    private static final String ERROR_SENDING_MAIL = "Error while sending mail";
    private static final String ATTACHMENTS_CAP = "Attachments cap reached, only first three will be sent";
    private static final String FILE_NOT_FOUND = "File by path: <%s> was not found in the system. "
            + "Message will be sent without it.";

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
        if (nonNull(emailDetails.getAttachments())) {
            prepareAttachments(emailDetails, mimeMessageHelper);
        }
    }

    private void prepareAttachments(final EmailDetails emailDetails,
                                    final MimeMessageHelper mimeMessageHelper) throws MessagingException {
        if (emailDetails.getAttachments().size() > attachmentsCapSize) {
            log.warn(ATTACHMENTS_CAP);
        }
        for (String attachment : emailDetails.getAttachments().subList(0, (attachmentsCapSize - 1))) {
            File fileInSystem = new File(attachment);
            if (fileInSystem.exists()) {
                FileSystemResource file = new FileSystemResource(fileInSystem);
                mimeMessageHelper.addAttachment(requireNonNull(file.getFilename()), file);
            } else {
                log.warn(String.format(FILE_NOT_FOUND, attachment));
            }
        }
    }
}
