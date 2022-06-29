package com.codesquad.issuetracker.auth.application;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtProvider {

    private static final int ACCESS_TOKEN_EXPIRES_MINUTE = 1;
    private static final int REFRESH_TOKEN_EXPIRES_WEEK = 3;
    public static final String USER_ID_CLAIM_KEY = "userId";
    private final Algorithm algorithm;

    public JwtProvider(@Value("${auth.jwt.secret_key}") String secretKey) {
        this.algorithm = Algorithm.HMAC256(secretKey);
    }

    public String createAccessToken(long userId) {
        Date accessTokenExpiredDate = Date.from(Instant.now().plus(ACCESS_TOKEN_EXPIRES_MINUTE, ChronoUnit.MINUTES));

        return JWT.create()
                .withClaim(USER_ID_CLAIM_KEY, userId)
                .withExpiresAt(accessTokenExpiredDate)
                .sign(algorithm);
    }

    public String createRefreshToken(long userId) {
        Date accessTokenExpiredDate = Date.from(Instant.now().plus(REFRESH_TOKEN_EXPIRES_WEEK, ChronoUnit.MINUTES));

        return JWT.create()
                .withClaim(USER_ID_CLAIM_KEY, userId)
                .withExpiresAt(accessTokenExpiredDate)
                .sign(algorithm);
    }

    public void validateJwtToken(String token) {
        JWT.require(algorithm).build().verify(token);
    }

    public Long getClaimFromToken(String token, String claim) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(claim).asLong();
    }
}
