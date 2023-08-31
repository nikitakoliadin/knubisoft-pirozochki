package com.knubisoft.application.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Card {
    private Long id;
    private String name;
    private String comment;
    private String imagePath;
}
