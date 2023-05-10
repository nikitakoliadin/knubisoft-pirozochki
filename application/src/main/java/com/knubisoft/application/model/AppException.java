package com.knubisoft.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class AppException {
    private String id;
    private String name;
    private String message;
    private int code;
}
