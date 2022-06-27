package com.codesquad.issuetracker.auth.presentation.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.auth.presentation.dto.AccessTokenDto;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/refresh")
    public AccessTokenDto refresh(HttpServletRequest request) {
        String refreshToken = request.getHeader("Authorization");
        return authService.refreshAccessToken(refreshToken);
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<String> handleJwtVerificationException(JWTVerificationException ex) {
        AuthExceptionType type = AuthExceptionType.INVALID_REFRESH_TOKEN;
        return ResponseEntity.status(type.getStatusCode()).body(type.getMessage());
    }

}
