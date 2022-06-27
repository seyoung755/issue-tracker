package com.codesquad.issuetracker.exception.domain.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum IssueExceptionType implements ExceptionType {

    NOT_FOUND(HttpStatus.NOT_FOUND, "ISSUE001", "이슈를 찾을 수 없습니다");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    IssueExceptionType(HttpStatus statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
