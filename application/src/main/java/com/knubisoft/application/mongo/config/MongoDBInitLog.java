package com.knubisoft.application.mongo.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.knubisoft.application.model.Developer;
import com.knubisoft.application.repository.DeveloperRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class MongoDBInitLog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Vladyslav")
    public void seedDatabase(DeveloperRepository developerRepository) {
        if (developerRepository.count() == 0) {
            List<Developer> developers = new ArrayList<>();
            developers.add(new Developer(1, "Vlad", 22));
            developers.add(new Developer(2, "Nikita", 22));
            developers.add(new Developer(3, "Vadim", 25));
            developerRepository.insert(developers);
        }
    }
}
