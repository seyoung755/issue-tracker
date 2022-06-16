package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.application.dto.GithubAccessToken;
import com.codesquad.issuetracker.user.application.dto.GithubTokenRequestDto;
import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
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
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public OAuthService(
            @Value("${oauth.github.client_id}") String clientId,
            @Value("${oauth.github.client_secret}") String clientSecret,
            UserRepository userRepository,
            JwtProvider jwtProvider) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponseDto login(String code) {

        GithubTokenRequestDto githubTokenRequestDto = new GithubTokenRequestDto(clientId, clientSecret, code);
        log.debug("OAuthService, login: {}", githubTokenRequestDto);

        GithubAccessToken githubAccessToken = requestAccessToken(githubTokenRequestDto);
        log.debug("OAuthService, access token: {}", githubAccessToken.getAccessToken());

        GithubUserInformation githubUserInformation = requestUserInformation(githubAccessToken);

        //db에 유저가 이미 있다면 로그인
        //db에 유저가 없다면 저장 후 로그인
        User user = userRepository.findByUserId("userId").orElseGet(()->{
            User u = new User();
            userRepository.save(u);
            return u;
        });

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());
        return new LoginResponseDto(accessToken, refreshToken);
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
