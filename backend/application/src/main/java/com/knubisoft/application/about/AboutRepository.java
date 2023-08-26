package com.knubisoft.application.about;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends MongoRepository<About, Long> {
}
