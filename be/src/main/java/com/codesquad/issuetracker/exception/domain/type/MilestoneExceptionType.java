package com.codesquad.issuetracker.exception.domain.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MilestoneExceptionType implements ExceptionType{

    NOT_FOUND(HttpStatus.NOT_FOUND, "MILE001", "마일스톤이 존재하지 않습니다.");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String message;

    MilestoneExceptionType(HttpStatus statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
