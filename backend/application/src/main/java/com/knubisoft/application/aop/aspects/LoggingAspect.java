package com.knubisoft.application.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public String sendEmail(com.knubisoft.application.entity.EmailDetails))")
    public void beforeSendingMail() {
        log.info("Preparing the message to send");
    }

    @Pointcut("execution(* com.knubisoft.application.service.EmailServiceImpl.sendEmail(..))")
    private void mailSendResult() { }

    @AfterReturning("mailSendResult()")
    public void afterSuccessMailSend() {
        log.info("Mail Sent Successfully");
    }

    @AfterThrowing("mailSendResult()")
    public void afterFailedMailSend() {
        log.info("Error while sending mail");
    }
}
