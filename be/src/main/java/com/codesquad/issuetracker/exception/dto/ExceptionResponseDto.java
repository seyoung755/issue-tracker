package com.codesquad.issuetracker.exception.dto;

import com.codesquad.issuetracker.exception.domain.type.ExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExceptionResponseDto {

    private String errorCode;
    private String message;

    public ExceptionResponseDto(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public static ExceptionResponseDto from(ExceptionType exceptionType) {
        return new ExceptionResponseDto(exceptionType.getErrorCode(), exceptionType.getMessage());
    }
}
