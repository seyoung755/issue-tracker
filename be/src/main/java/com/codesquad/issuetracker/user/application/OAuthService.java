package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.user.application.dto.GithubAccessToken;
import com.codesquad.issuetracker.user.application.dto.GithubTokenRequestDto;
import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Transactional
@Service
public class OAuthService {

    private static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_RESOURCE_URL = "https://api.github.com/user";

    private final String clientId;
    private final String clientSecret;

    public OAuthService(
            @Value("${oauth.github.client_id}") String clientId,
            @Value("${oauth.github.client_secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public LoginResponseDto login(String code) {

        GithubTokenRequestDto githubTokenRequestDto = new GithubTokenRequestDto(clientId, clientSecret, code);

        log.debug("OAuthService, login: {}", githubTokenRequestDto);

        GithubAccessToken accessToken = requestAccessToken(githubTokenRequestDto);
        log.debug("OAuthService, access token: {}", accessToken.getAccessToken());
        GithubUserInformation githubUserInformation = requestUserInformation(accessToken);

        return null;
    }

    private GithubAccessToken requestAccessToken(GithubTokenRequestDto githubTokenRequestDto) {
        return WebClient
                .builder()
                .baseUrl(GITHUB_ACCESS_TOKEN_URL)
                .build()
                .post()
                .bodyValue(githubTokenRequestDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubAccessToken.class)
                .block();
    }

    private GithubUserInformation requestUserInformation(GithubAccessToken githubAccessToken) {
        String tokenString = createTokenString(githubAccessToken);

        String userInformation = WebClient.builder()
                .baseUrl(GITHUB_RESOURCE_URL)
                .build()
                .get()
                .header("Authorization", tokenString)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("OAuthService, requestUserInfo.: {}", userInformation);

        return null;
    }

    private String createTokenString(GithubAccessToken githubAccessToken) {
        return "token " + githubAccessToken.getAccessToken();
    }
}
