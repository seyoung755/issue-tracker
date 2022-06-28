package com.codesquad.issuetracker.auth.presentation.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.auth.presentation.dto.AccessTokenDto;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import com.codesquad.issuetracker.exception.dto.ExceptionResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Access 토큰 갱신하기", description = "Refresh token을 통해 Access 토큰을 재발급합니다.")
    @GetMapping("/auth/refresh")
    public AccessTokenDto refresh(@CookieValue(value = "refreshToken") Cookie refreshToken) {
        return authService.refreshAccessToken(refreshToken.getValue());
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ExceptionResponseDto> handleJwtVerificationException(JWTVerificationException ex) {
        ex.printStackTrace();
        AuthExceptionType type = AuthExceptionType.INVALID_REFRESH_TOKEN;
        ExceptionResponseDto exceptionResponseDto =
                new ExceptionResponseDto(type.getErrorCode(), type.getMessage());
        return ResponseEntity.status(type.getStatusCode()).body(exceptionResponseDto);
    }

    @ExceptionHandler(MissingRequestCookieException.class)
    public ResponseEntity<ExceptionResponseDto> handleMissingRequestCookieException(MissingRequestCookieException ex) {
        ex.printStackTrace();
        AuthExceptionType type = AuthExceptionType.REFRESH_TOKEN_NOT_FOUND;
        ExceptionResponseDto exceptionResponseDto =
                new ExceptionResponseDto(type.getErrorCode(), type.getMessage());
        return ResponseEntity.status(type.getStatusCode()).body(exceptionResponseDto);
    }

}
