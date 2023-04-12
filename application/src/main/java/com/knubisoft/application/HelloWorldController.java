package com.knubisoft.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @Value("${value}")
    String value;

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
}
