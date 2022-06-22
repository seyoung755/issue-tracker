package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BasicLoginService {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    public LoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = userService.findByUsername(userLoginRequestDto.getUsername())
                .orElseThrow(() -> new BusinessException(UserExceptionType.NOT_FOUND));

        user.validatePassword(userLoginRequestDto.getPassword());

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());

        user.saveRefreshToken(refreshToken);

        return new LoginResponseDto(accessToken, refreshToken);
    }

    public void logout(User user) {
        user.expireRefreshToken();
        userService.save(user);
    }
}
