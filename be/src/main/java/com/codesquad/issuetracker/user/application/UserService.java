package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.user.domain.UserRepository;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinFormDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public UserService(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    public LoginResponseDto login() {
        return null;
    }

    public void join(UserJoinFormDto userJoinFormDto) {
    }

}
