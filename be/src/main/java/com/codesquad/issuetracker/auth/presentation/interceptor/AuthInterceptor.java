package com.codesquad.issuetracker.auth.presentation.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String TOKEN_TYPE = "Bearer ";

    private final AuthService authService;

    public AuthInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug("request-uri: {}", request.getRequestURI());

        String authorization = request.getHeader("Authorization");
        String token = parseToken(authorization);

        try {
            authService.validateToken(token);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            throw new BusinessException(AuthExceptionType.TOKEN_EXPIRED);
        } catch (SignatureVerificationException | JWTDecodeException e) {
            e.printStackTrace();
            throw new BusinessException(AuthExceptionType.INVALID_TOKEN);
        }

        User user = authService.findUser(token);
        request.setAttribute("user", user);

        return true;
    }

    private String parseToken(String authorization) {
        String token;
        try {
            validateAuthorizationHeader(authorization);
            token = authorization.split(" ")[1].trim();
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new BusinessException(AuthExceptionType.TOKEN_NOT_FOUND);
        }
        return token;
    }

    private void validateAuthorizationHeader(String authorization) {
        if (authorization == null || !authorization.startsWith(TOKEN_TYPE)) {
            throw new IllegalArgumentException("토큰의 형식이 잘못되었습니다.");
        }
    }
}
