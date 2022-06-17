package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinFormDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginFormDto;
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

    public LoginResponseDto login(UserLoginFormDto userLoginFormDto) {
        User user = userRepository.findByUserId(userLoginFormDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        user.validatePassword(userLoginFormDto.getPassword());

        String accessToken = jwtProvider.createAccessToken(user.getId());
        String refreshToken = jwtProvider.createRefreshToken(user.getId());
        return new LoginResponseDto(accessToken, refreshToken);
    }

    public void join(UserJoinFormDto userJoinFormDto) {

        //유저 아이디 중복 검증
        if (isDuplicatedUserId(userJoinFormDto.getUserId())) {
            throw new IllegalArgumentException("중복된 id 입니다.");
        }

        //자체 회원가입 시 비밀번호를 암호화해서 저장해야할까?
        User user = new User(userJoinFormDto.getUserId(),
                userJoinFormDto.getUsername(),
                userJoinFormDto.getPassword(),
                userJoinFormDto.getProfileImage());

        userRepository.save(user);
    }

    public boolean isDuplicatedUserId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

}
