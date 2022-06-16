package com.codesquad.issuetracker.auth.application;

import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public AuthService(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    public User checkTokenAndFindUser(String token) {

        // TODO: 2022/06/16 validateAccessToken에서 발생하는 에러를 처리하는 로직이 필요함.
        long userId = jwtProvider.validateJwtToken(token);

        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException(""));
    }
}
