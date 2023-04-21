package com.knubisoft.application;

import com.knubisoft.application.model.Developer;
import com.knubisoft.application.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitMongoDB {
    private DeveloperRepository repository;

    @Autowired
    public InitMongoDB(DeveloperRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void init() {
        if (repository.findAll().isEmpty()) {
            List<Developer> developers = new ArrayList<>();
            developers.add(new Developer(1, "Vlad", 22));
            developers.add(new Developer(2, "Nikita", 22));
            developers.add(new Developer(3, "Vadim", 25));
            repository.insert(developers);
        }
    }
}
