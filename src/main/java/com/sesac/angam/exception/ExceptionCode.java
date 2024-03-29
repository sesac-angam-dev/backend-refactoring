package com.sesac.angam.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {
    USER_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR,500, "유저를 찾을 수 없습니다."),
    POST_NOT_FOUND(HttpStatus.BAD_REQUEST, 400, "해당 게시물이 존재하지 않습니다."),
    POST_ALREADY_LIKED(HttpStatus.BAD_REQUEST, 400, "이미 좋아요가 존재합니다."),
    LIKE_NOT_FOUND(HttpStatus.BAD_REQUEST, 400, "해당 좋아요가 존재하지 않습니다."),
    SIZE_NOT_FOUND(HttpStatus.BAD_REQUEST, 400, "해당 사이즈가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    ExceptionCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
