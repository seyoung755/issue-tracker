package com.codesquad.issuetracker.exception.domain.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommentExceptionType implements ExceptionType {

    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT001", "댓글을 찾을 수 없습니다");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    CommentExceptionType(HttpStatus statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
