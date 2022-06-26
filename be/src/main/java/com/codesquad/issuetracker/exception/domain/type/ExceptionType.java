package com.codesquad.issuetracker.exception.domain.type;

import org.springframework.http.HttpStatus;

public interface ExceptionType {

    String getMessage();
    String getErrorCode();
    HttpStatus getStatusCode();
}
