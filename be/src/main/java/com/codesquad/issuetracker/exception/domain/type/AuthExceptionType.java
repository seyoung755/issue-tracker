package com.codesquad.issuetracker.exception.domain.type;

import org.springframework.http.HttpStatus;

public enum AuthExceptionType implements ExceptionType {

    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "AUTH001", "이 api에 접근하기 위해서는 Access 토큰이 필요합니다."),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "AUTH002", "액세스 토큰이 만료되었습니다."),
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH003", "유효하지 않은 Access 토큰입니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH004", "유효하지 않은 Refresh 토큰입니다.");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    AuthExceptionType(HttpStatus statusCode, String errorCode, String message) {
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
