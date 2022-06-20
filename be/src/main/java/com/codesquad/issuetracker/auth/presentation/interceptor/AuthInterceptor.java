package com.codesquad.issuetracker.auth.presentation.interceptor;

import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    public AuthInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug("request-uri: {}", request.getRequestURI());

        String authorization = request.getHeader("Authorization");
        User user = authService.checkTokenAndFindUser(authorization);

        request.setAttribute("user", user);

        return true;
    }
}
