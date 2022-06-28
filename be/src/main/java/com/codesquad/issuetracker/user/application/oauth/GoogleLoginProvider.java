package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.common.properties.GoogleProperty;
import com.codesquad.issuetracker.user.application.dto.GoogleAccessToken;
import com.codesquad.issuetracker.user.application.dto.GoogleTokenRequestDto;
import com.codesquad.issuetracker.user.application.dto.GoogleUserInformation;
import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import com.codesquad.issuetracker.user.domain.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Transactional
@Service
public class GoogleLoginProvider implements OAuthProvider {

    private final GoogleProperty googleProperty;

    public GoogleLoginProvider(GoogleProperty googleProperty) {
        this.googleProperty = googleProperty;
    }

    @Override
    public LoginType getOAuthType() {
        return LoginType.GOOGLE;
    }

    @Override
    public String getRedirectUrl() {
        return googleProperty.getRedirectUrl();
    }

    @Override
    public OAuthUserInformation requestUserInformation(String code) {
        GoogleTokenRequestDto googleTokenRequestDto = new GoogleTokenRequestDto(googleProperty.getClientId(), googleProperty.getClientSecret(), code);
        log.debug("OAuthService, login: {}", googleTokenRequestDto);

        GoogleAccessToken googleAccessToken = requestAccessToken(googleTokenRequestDto);
        log.debug("OAuthService, access token: {}", googleAccessToken.getScope());

        return requestUserInformation(googleAccessToken);
    }

    private GoogleAccessToken requestAccessToken(GoogleTokenRequestDto googleTokenRequestDto) {
        return WebClient
                .builder()
                .baseUrl(googleProperty.getAccessTokenUrl())
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
                .baseUrl(googleProperty.getResourceUrl())
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
