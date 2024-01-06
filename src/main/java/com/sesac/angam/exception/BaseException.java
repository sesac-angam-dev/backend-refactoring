package com.sesac.angam.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private ExceptionCode code;

    BaseException(ExceptionCode code) {
        this.code = code;
    }
}
