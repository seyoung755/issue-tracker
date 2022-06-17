package com.codesquad.issuetracker.auth.presentation.interceptor;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.codesquad.issuetracker.auth.application.JwtProvider;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    public LoginInterceptor(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");

        if (authorization == null) {
            return true;
        }

        try {
            jwtProvider.validateJwtToken(authorization);
        } catch (SignatureVerificationException | TokenExpiredException | IllegalArgumentException e) {
            return true;
        }

        //todo: 고민사항 - 여기서 새로운 토큰을 보내줘야할까?
        return false;

    }
}
