package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import com.codesquad.issuetracker.user.application.oauth.GithubLoginService;
import com.codesquad.issuetracker.user.application.oauth.OAuthProvider;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class OAuthLoginService {

    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final GithubLoginService githubLoginService;

    public LoginResponseDto githubLogin(String code) {
        return login(code, githubLoginService);
    }

    public LoginResponseDto login(String code, OAuthProvider oAuthProvider) {
        GithubUserInformation githubUserInformation = oAuthProvider.requestUserInformation(code);

        User user = userService.oAuthLogin(githubUserInformation);

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());

        user.saveRefreshToken(refreshToken);

        return new LoginResponseDto(accessToken, refreshToken);
    }
}
