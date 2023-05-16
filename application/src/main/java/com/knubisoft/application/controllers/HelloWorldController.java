package com.knubisoft.application.controllers;

import com.knubisoft.application.exception.ApiRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @Value("${config.value}")
    private String value;

    @RequestMapping("/hello")
    public String helloWorld() {
        log.info("Now we are at controller: {}", HelloWorldController.class.getSimpleName());
        return "Hello World";
    }

    @RequestMapping("/value")
    public String value() {
        log.info("Now we are at controller: {}", HelloWorldController.class.getSimpleName());
        return value;
    }

    @RequestMapping("/exception")
    public String getException() {
        throw new ApiRequestException("This is exception message");
    }
}
