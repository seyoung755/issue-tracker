package com.codesquad.issuetracker.user.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GoogleTokenRequestDto {

    private String clientId;
    private String clientSecret;
    private String code;
    private String grantType;
    private String redirectUri;

    public GoogleTokenRequestDto(String clientId, String clientSecret, String code) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.grantType = "authorization_code";
        this.redirectUri = "http://localhost:8080/oauth/google/callback";
    }
}
