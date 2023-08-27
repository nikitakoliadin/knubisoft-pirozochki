package com.knubisoft.application.faq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Faq {
    private Long id;
    private String question;
    private String answer;
}
