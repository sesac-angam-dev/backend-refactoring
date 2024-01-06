package com.sesac.angam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ExceptionResponse> handleBaseException(BaseException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.from(exception);

        return ResponseEntity
                .status(exceptionResponse.getHttpStatus())
                .body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.from(exception);

        return ResponseEntity
                .status(exceptionResponse.getHttpStatus())
                .body(exceptionResponse);
    }

}
