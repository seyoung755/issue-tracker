package com.codesquad.issuetracker.exception.domain.type;

import org.springframework.http.HttpStatus;

public enum AuthExceptionType implements ExceptionType{

    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "이 api에 접근하기 위해서는 Access 토큰이 필요합니다."),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "액세스 토큰이 만료되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다");

    private final HttpStatus statusCode;
    private final String message;

    AuthExceptionType(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
