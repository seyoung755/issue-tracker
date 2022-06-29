package com.codesquad.issuetracker.exception.domain.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum LabelExceptionType implements ExceptionType {

    NOT_FOUND(HttpStatus.NOT_FOUND, "LABEL001", "라벨을 찾을 수 없습니다");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    LabelExceptionType(HttpStatus statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
