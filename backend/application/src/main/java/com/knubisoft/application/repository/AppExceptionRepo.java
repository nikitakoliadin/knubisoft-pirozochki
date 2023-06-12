package com.knubisoft.application.repository;

import com.knubisoft.application.model.AppException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppExceptionRepo extends MongoRepository<AppException, String> { }
