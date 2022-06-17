package com.codesquad.issuetracker.exception.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExceptionResponseDto {

    private int code;
    private String message;

    public ExceptionResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
