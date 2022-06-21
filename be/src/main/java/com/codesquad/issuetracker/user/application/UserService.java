package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Transactional
@Service
public class UserService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public UserService(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    public LoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findByUsername(userLoginRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(""));

        user.validatePassword(userLoginRequestDto.getPassword());

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());
        return new LoginResponseDto(accessToken, refreshToken);
    }

    public User join(UserJoinRequestDto userJoinRequestDto, LoginType loginType) {

        if (isDuplicatedUsername(userJoinRequestDto.getUsername())) {
            throw new IllegalArgumentException();
        }

        User user = new User(userJoinRequestDto.getUsername(),
                userJoinRequestDto.getName(),
                userJoinRequestDto.getPassword(),
                userJoinRequestDto.getProfileImage(),
                loginType);

        return userRepository.save(user);
    }

    public boolean isDuplicatedUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User oAuthLogin(OAuthUserInformation oAuthUserInformation) {
        return userRepository.findByUsername(oAuthUserInformation.getUsername())
                .orElseGet(() -> join(new UserJoinRequestDto(
                        oAuthUserInformation.getUsername(),
                        oAuthUserInformation.getName(),
                        oAuthUserInformation.getPassword(),
                        oAuthUserInformation.getProfileImage()), oAuthUserInformation.getLoginType()));
    }
}
