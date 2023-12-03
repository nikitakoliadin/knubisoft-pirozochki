package com.knubisoft.application.exception;

import com.knubisoft.application.model.AppException;
import com.knubisoft.application.repository.AppExceptionRepo;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final AppExceptionRepo exceptionRepo;

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<AppException> handleApiRequestException(final ApiRequestException e) {
        return handleException(e, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(value = {CodeNotFoundException.class})
    public ResponseEntity<AppException> handleCustomExceptions(final RuntimeException e) {
        return handleException(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<AppException> handleAuthenticationException(final AuthenticationException e) {
        return handleException(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppException> handleValidationException(final MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String fieldName = fieldError.getField();
        String errorMessage = fieldError.getDefaultMessage();
        return handleException("Validation failed for field: " + fieldName + ". " + errorMessage);
    }

    private ResponseEntity<AppException> handleException(final Exception e, final HttpStatus status) {
        AppException appException = new AppException();
        appException.setName(e.getClass().getName());
        appException.setMessage(e.getMessage());
        appException.setCode(status.value());
        AppException savedException = exceptionRepo.insert(appException);
        return new ResponseEntity<>(savedException, status);
    }

    private ResponseEntity<AppException> handleException(final String errorMessage) {
        AppException appException = new AppException();
        appException.setName("MethodArgumentNotValidException");
        appException.setMessage(errorMessage);
        appException.setCode(HttpStatus.BAD_REQUEST.value());
        AppException savedException = exceptionRepo.insert(appException);
        return new ResponseEntity<>(savedException, HttpStatus.BAD_REQUEST);
    }
}
