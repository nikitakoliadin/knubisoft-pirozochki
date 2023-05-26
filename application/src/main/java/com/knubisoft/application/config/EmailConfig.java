package com.knubisoft.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@EnableConfigurationProperties
public class EmailConfig {

    @Bean(name = "smtpMailSender")
    @ConfigurationProperties(prefix = "spring.mail.smtp")
    public JavaMailSender smtpMailSender() {
        return new JavaMailSenderImpl();
    }

    @Bean(name = "pop3MailSender")
    @ConfigurationProperties(prefix = "spring.mail.pop3")
    public JavaMailSender pop3MailSender() {
        return new JavaMailSenderImpl();
    }

    @Bean(name = "imapMailSender")
    @ConfigurationProperties(prefix = "spring.mail.imap")
    public JavaMailSender imapMailSender() {
        return new JavaMailSenderImpl();
    }

}

