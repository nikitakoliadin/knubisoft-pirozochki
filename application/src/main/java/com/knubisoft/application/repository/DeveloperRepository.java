package com.knubisoft.application.repository;

import com.knubisoft.application.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeveloperRepository extends MongoRepository<Developer, Integer> {
}
