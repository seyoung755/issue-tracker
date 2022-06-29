package com.codesquad.issuetracker.auth.presentation.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.common.util.TokenParser;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import com.codesquad.issuetracker.user.application.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug("request-uri: {}", request.getRequestURI());

        if (StringUtils.equals(request.getMethod(), "OPTIONS")) {
            log.debug("if request options method is options, return true");

            return true;
        }

        String authorization = request.getHeader("Authorization");
        String token = TokenParser.parseToken(authorization);

        try {
            jwtProvider.validateJwtToken(token);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            throw new BusinessException(AuthExceptionType.TOKEN_EXPIRED);
        } catch (SignatureVerificationException | JWTDecodeException e) {
            e.printStackTrace();
            throw new BusinessException(AuthExceptionType.INVALID_ACCESS_TOKEN);
        }

        Long userId = jwtProvider.getClaimFromToken(token, JwtProvider.USER_ID_CLAIM_KEY);
        userService.doesExist(userId);

        request.setAttribute("userId", userId);
        return true;
    }

}
