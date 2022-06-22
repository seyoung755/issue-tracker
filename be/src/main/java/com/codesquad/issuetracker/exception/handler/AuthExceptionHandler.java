package com.codesquad.issuetracker.exception.handler;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.ExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.exception.dto.ExceptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> exceptionHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        UserExceptionType exceptionType = UserExceptionType.INVALID_FORMAT;
        return createResponseEntity(exceptionType);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponseDto> handleBusinessException(HttpServletRequest request, BusinessException exception) {
        return createResponseEntity(exception.getExceptionType());
    }

    private ResponseEntity<ExceptionResponseDto> createResponseEntity(ExceptionType exceptionType) {
        return ResponseEntity.status(exceptionType.getStatusCode()).body(ExceptionResponseDto.from(exceptionType));
    }
}
