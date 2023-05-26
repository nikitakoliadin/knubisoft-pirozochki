package com.knubisoft.application.service;

import com.knubisoft.application.entity.EmailDetails;

public interface EmailService {
    String sendEmail(EmailDetails emailDetails);
}
