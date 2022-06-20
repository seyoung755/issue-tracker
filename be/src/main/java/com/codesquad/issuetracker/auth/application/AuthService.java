package com.codesquad.issuetracker.auth.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import org.springframework.stereotype.Service;

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
}
