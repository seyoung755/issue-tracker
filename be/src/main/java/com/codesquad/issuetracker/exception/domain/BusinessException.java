package com.codesquad.issuetracker.exception.domain;

import com.codesquad.issuetracker.exception.domain.type.ExceptionType;

public class BusinessException extends RuntimeException {

    private final ExceptionType exceptionType;

    public BusinessException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}
