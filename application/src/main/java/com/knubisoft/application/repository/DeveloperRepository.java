package com.knubisoft.application.repository;

import com.knubisoft.application.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, Integer> {
}
