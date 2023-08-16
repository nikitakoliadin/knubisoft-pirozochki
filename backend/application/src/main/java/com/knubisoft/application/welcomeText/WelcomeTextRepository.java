package com.knubisoft.application.welcomeText;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomeTextRepository extends MongoRepository<WelcomeText, Long> {
}
