package com.knubisoft.application.faq;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends MongoRepository<Faq, Long> {
}
