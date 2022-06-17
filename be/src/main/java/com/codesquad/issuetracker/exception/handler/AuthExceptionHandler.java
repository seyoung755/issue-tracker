package com.codesquad.issuetracker.exception.handler;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.codesquad.issuetracker.exception.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//todo Exception 클래스를 추상화하고, enum으로 상태코드, 메세지 관리.

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponseDto> exceptionHandler(HttpServletRequest request, IllegalArgumentException ex) {
        return ResponseEntity.ok().body(new ExceptionResponseDto(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler({SignatureVerificationException.class})
    public ResponseEntity<ExceptionResponseDto> exceptionHandler(HttpServletRequest request, SignatureVerificationException ex) {
        return ResponseEntity.ok().body(new ExceptionResponseDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()));
    }

    @ExceptionHandler({TokenExpiredException.class})
    public ResponseEntity<ExceptionResponseDto> exceptionHandler(HttpServletRequest request, TokenExpiredException ex) {
        return ResponseEntity.ok().body(new ExceptionResponseDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()));
    }
}
