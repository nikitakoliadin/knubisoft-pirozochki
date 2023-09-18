package com.knubisoft.application.welcome_text;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomeTextRepository extends MongoRepository<WelcomeText, Long> {
}
