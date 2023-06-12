package com.knubisoft.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Data
@Document
public class Developer {
    private Integer id;
    private String name;
    private Integer age;

}
