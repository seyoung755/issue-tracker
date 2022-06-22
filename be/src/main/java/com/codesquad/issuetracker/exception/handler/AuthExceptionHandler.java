package com.codesquad.issuetracker.exception.handler;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exceptionHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("아이디나 비밀번호 형식이 잘못 되었습니다.");
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(HttpServletRequest request, BusinessException exception) {
        return ResponseEntity.status(exception.getExceptionType().getStatusCode()).body(exception.getMessage());
    }
}
