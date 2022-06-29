package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import com.codesquad.issuetracker.user.application.oauth.OAuthProvider;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumMap;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class OAuthLoginService {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    private final EnumMap<LoginType, OAuthProvider> oAuthProviderEnumMap;

    public String getRedirectUrl(LoginType type) {
        OAuthProvider oAuthProvider = oAuthProviderEnumMap.get(type);
        return oAuthProvider.getRedirectUrl();
    }

    public LoginResponseDto login(String code, LoginType type) {
        OAuthProvider oAuthProvider = oAuthProviderEnumMap.get(type);
        OAuthUserInformation oAuthUserInformation = oAuthProvider.requestUserInformation(code);
        User user = oAuthLogin(oAuthUserInformation);

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());

        user.saveRefreshToken(refreshToken);

        return new LoginResponseDto(accessToken, refreshToken);
    }

    private User oAuthLogin(OAuthUserInformation oAuthUserInformation) {
        return userService.findByUsername(oAuthUserInformation.getUsername())
                .orElseGet(() -> userService.join(UserJoinRequestDto.from(oAuthUserInformation)));
    }
}
