package com.knubisoft.application.service;

import com.knubisoft.application.entity.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails emailDetails);
    String sendEmailWithAttachment(EmailDetails emailDetails);
}
