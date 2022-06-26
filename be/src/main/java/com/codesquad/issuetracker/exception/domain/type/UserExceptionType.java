package com.codesquad.issuetracker.exception.domain.type;

import org.springframework.http.HttpStatus;

public enum UserExceptionType implements ExceptionType {

    NOT_FOUND(HttpStatus.NOT_FOUND, "USER001","유저를 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "USER002","비밀번호가 틀렸습니다."),
    INVALID_FORMAT(HttpStatus.BAD_REQUEST, "USER003", "아이디나 비밀번호 형식이 잘못 되었습니다."),
    DUPLICATED_USERNAME(HttpStatus.BAD_REQUEST, "USER004","이미 가입된 아이디입니다.");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    UserExceptionType(HttpStatus statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
