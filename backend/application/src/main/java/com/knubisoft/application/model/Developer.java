package com.knubisoft.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Developer {
    private Integer id;
    private String name;
    private Integer age;

}
