package com.knubisoft.application;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
@EnableEncryptableProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
