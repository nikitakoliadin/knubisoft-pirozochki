package com.knubisoft.application.welcomeText;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class WelcomeText {
    private Long id;
    private String text;
}
