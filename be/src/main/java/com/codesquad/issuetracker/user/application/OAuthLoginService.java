package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import com.codesquad.issuetracker.user.application.oauth.GithubLoginService;
import com.codesquad.issuetracker.user.application.oauth.GoogleLoginService;
import com.codesquad.issuetracker.user.application.oauth.OAuthProvider;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
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
    private final GoogleLoginService googleLoginService;

    public LoginResponseDto githubLogin(String code) {
        return login(code, githubLoginService);
    }

    public LoginResponseDto googleLogin(String code) {
        return login(code, googleLoginService);
    }

    public LoginResponseDto login(String code, OAuthProvider oAuthProvider) {
        OAuthUserInformation oAuthUserInformation = oAuthProvider.requestUserInformation(code);

        User user = oAuthLogin(oAuthUserInformation);

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());

        user.saveRefreshToken(refreshToken);

        return new LoginResponseDto(accessToken, refreshToken);
    }

    public User oAuthLogin(OAuthUserInformation oAuthUserInformation) {
        return userService.findByUsername(oAuthUserInformation.getUsername())
                .orElseGet(() -> userService.join(UserJoinRequestDto.from(oAuthUserInformation)));
    }
}
