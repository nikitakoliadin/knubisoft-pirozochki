package com.knubisoft.application.exception;

import com.knubisoft.application.model.AppException;
import com.knubisoft.application.repository.AppExceptionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final AppExceptionRepo exceptionRepo;

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<AppException> handleApiRequestException(final ApiRequestException e) {
        AppException appException = new AppException();
        appException.setName(e.getClass().getName());
        appException.setMessage(e.getMessage());
        appException.setCode(HttpStatus.I_AM_A_TEAPOT.value());
        AppException savedException = exceptionRepo.insert(appException);
        return new ResponseEntity<>(savedException, HttpStatus.I_AM_A_TEAPOT);
    }
}
