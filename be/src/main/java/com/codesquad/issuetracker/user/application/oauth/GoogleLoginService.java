package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.user.application.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Transactional
@Service
public class GoogleLoginService implements OAuthProvider {

    private static final String GOOGLE_ACCESS_TOKEN_URL = "https://oauth2.googleapis.com/token";
    private static final String GOOGLE_RESOURCE_URL = "https://www.googleapis.com/oauth2/v2/userinfo?alt=json";

    private final String clientId;
    private final String clientSecret;

    public GoogleLoginService(
            @Value("${oauth.google.client_id}") String clientId,
            @Value("${oauth.google.client_secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public OAuthUserInformation requestUserInformation(String code) {
        GoogleTokenRequestDto googleTokenRequestDto = new GoogleTokenRequestDto(clientId, clientSecret, code);
        log.debug("OAuthService, login: {}", googleTokenRequestDto);

        GoogleAccessToken googleAccessToken = requestAccessToken(googleTokenRequestDto);
        log.debug("OAuthService, access token: {}", googleAccessToken.getScope());

        return requestUserInformation(googleAccessToken);
    }

    private GoogleAccessToken requestAccessToken(GoogleTokenRequestDto googleTokenRequestDto) {
        return WebClient
                .builder()
                .baseUrl(GOOGLE_ACCESS_TOKEN_URL)
                .build()
                .post()
                .bodyValue(googleTokenRequestDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GoogleAccessToken.class)
                .block();
    }

    private GoogleUserInformation requestUserInformation(GoogleAccessToken googleAccessToken) {
        String tokenString = createTokenString(googleAccessToken);

        GoogleUserInformation userInformation = WebClient.builder()
                .baseUrl(GOOGLE_RESOURCE_URL)
                .build()
                .get()
                .header("Authorization", tokenString)
                .retrieve()
                .bodyToMono(GoogleUserInformation.class)
                .block();

        log.debug("OAuthService, requestUserInfo.: {}", userInformation);

        return userInformation;
    }

    private String createTokenString(GoogleAccessToken googleAccessToken) {
        return googleAccessToken.getTokenType() + " " + googleAccessToken.getAccessToken();
    }
}
