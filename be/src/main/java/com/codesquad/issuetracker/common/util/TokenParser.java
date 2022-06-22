package com.codesquad.issuetracker.common.util;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;

public class TokenParser {

    private static final String TOKEN_TYPE = "Bearer ";

    public static String parseToken(String authorization) {
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

    private static void validateAuthorizationHeader(String authorization) {
        if (authorization == null || !authorization.startsWith(TOKEN_TYPE)) {
            throw new IllegalArgumentException("토큰의 형식이 잘못되었습니다.");
        }
    }

}
