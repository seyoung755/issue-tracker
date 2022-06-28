package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.common.properties.GithubProperty;
import com.codesquad.issuetracker.user.application.dto.GithubAccessToken;
import com.codesquad.issuetracker.user.application.dto.GithubTokenRequestDto;
import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import com.codesquad.issuetracker.user.domain.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Transactional
@Service
public class GithubLoginProvider implements OAuthProvider {

    private final GithubProperty githubProperty;

    public GithubLoginProvider(GithubProperty githubProperty) {
        this.githubProperty = githubProperty;
    }


    @Override
    public LoginType getOAuthType() {
        return LoginType.GITHUB;
    }

    @Override
    public String getRedirectUrl() {
        return githubProperty.getRedirectUrl();
    }

    @Override
    public GithubUserInformation requestUserInformation(String code) {
        GithubTokenRequestDto githubTokenRequestDto = new GithubTokenRequestDto(githubProperty.getClientId(), githubProperty.getClientSecret(), code);
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
                .baseUrl(githubProperty.getAccessTokenUrl())
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
                .baseUrl(githubProperty.getResourceUrl())
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
