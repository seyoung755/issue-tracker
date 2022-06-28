package com.codesquad.issuetracker.auth.application;

import com.codesquad.issuetracker.auth.presentation.dto.AccessTokenDto;
import com.codesquad.issuetracker.common.util.TokenParser;
import com.codesquad.issuetracker.user.application.UserService;
import com.codesquad.issuetracker.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    public AccessTokenDto refreshAccessToken(String refreshToken) {
        jwtProvider.validateJwtToken(refreshToken);
        Long userId = jwtProvider.getClaimFromToken(refreshToken, JwtProvider.USER_ID_CLAIM_KEY);

        User user = userService.findById(userId);
        user.validateRefreshToken(refreshToken);

        String accessToken = jwtProvider.createAccessToken(user.getId());

        return new AccessTokenDto(accessToken);
    }


}
