package com.sesac.angam.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ExceptionResponse {
    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    public static ExceptionResponse from(BaseException exception) {
        return ExceptionResponse.builder()
                .httpStatus(exception.getCode().getHttpStatus())
                .code(exception.getCode().getCode())
                .message(exception.getCode().getMessage())
                .build();
    }

    public static ExceptionResponse from(Exception exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .build();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
