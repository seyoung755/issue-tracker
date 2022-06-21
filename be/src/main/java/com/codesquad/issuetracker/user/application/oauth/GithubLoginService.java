package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.user.application.dto.GithubAccessToken;
import com.codesquad.issuetracker.user.application.dto.GithubTokenRequestDto;
import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Transactional
@Service
public class GithubLoginService implements OAuthProvider {

    private static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_RESOURCE_URL = "https://api.github.com/user";

    private final String clientId;
    private final String clientSecret;

    public GithubLoginService(
            @Value("${oauth.github.client_id}") String clientId,
            @Value("${oauth.github.client_secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public GithubUserInformation requestUserInformation(String code) {
        GithubTokenRequestDto githubTokenRequestDto = new GithubTokenRequestDto(clientId, clientSecret, code);
        log.debug("OAuthService, login: {}", githubTokenRequestDto);

        GithubAccessToken githubAccessToken = requestAccessToken(githubTokenRequestDto);
        log.debug("OAuthService, access token: {}", githubAccessToken.getAccessToken());

        GithubUserInformation githubUserInformation = requestUserInformation(githubAccessToken);
        log.debug("OAuthService, github user information: {}", githubUserInformation);

        return githubUserInformation;
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

        GithubUserInformation userInformation = WebClient.builder()
                .baseUrl(GITHUB_RESOURCE_URL)
                .build()
                .get()
                .header("Authorization", tokenString)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubUserInformation.class)
                .block();

        log.debug("OAuthService, requestUserInfo.: {}", userInformation);
        String username = generateUsername(userInformation.getUsername());
        userInformation.setUsername(username);

        return userInformation;
    }

    private String generateUsername(String username) {
        return "GITHUB_" + username;
    }

    private String createTokenString(GithubAccessToken githubAccessToken) {
        return "token " + githubAccessToken.getAccessToken();
    }
}
