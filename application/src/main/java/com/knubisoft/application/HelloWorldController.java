package com.knubisoft.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Value("${value}")
    String value;

    @RequestMapping("/hello")
    public String helloWorld() {
        logger.info("Now we are at controller: {}", HelloWorldController.class.getSimpleName());
        return "Hello World";
    }

    @RequestMapping("/value")
    public String value() {
        logger.info("Now we are at controller: {}", HelloWorldController.class.getSimpleName());
        return value;
    }
}
