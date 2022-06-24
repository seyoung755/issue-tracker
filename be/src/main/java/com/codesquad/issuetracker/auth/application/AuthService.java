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

    public User checkTokenAndFindUser(String authorization) {

        String token = authorization.split(" ")[1].trim();
        long userId = jwtProvider.validateJwtToken(token);

        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException(""));
    }
}
