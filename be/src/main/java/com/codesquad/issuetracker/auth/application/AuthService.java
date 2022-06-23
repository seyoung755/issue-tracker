package com.codesquad.issuetracker.auth.application;

import com.codesquad.issuetracker.auth.presentation.dto.AccessTokenDto;
import com.codesquad.issuetracker.common.util.TokenParser;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class AuthService {

    private static final String USER_ID = "userId";

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public AuthService(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    public void validateToken(String token) {
        jwtProvider.validateJwtToken(token);
    }

    public User findUser(String token) {
        Long userId = jwtProvider.getClaimFromToken(token, USER_ID);

        return userRepository.findById(userId)
                .orElseThrow(()-> new BusinessException(UserExceptionType.NOT_FOUND));
    }

    public AccessTokenDto refreshAccessToken(String authorization) {
        String refreshToken = TokenParser.parseToken(authorization);

        jwtProvider.validateJwtToken(refreshToken);

        User user = findUser(refreshToken);
        user.validateRefreshToken(refreshToken);

        String accessToken = jwtProvider.createAccessToken(user.getId());

        return new AccessTokenDto(accessToken);
    }


}
