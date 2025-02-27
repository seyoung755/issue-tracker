package com.codesquad.issuetracker.user.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
import com.codesquad.issuetracker.user.presentation.dto.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User join(UserJoinRequestDto userJoinRequestDto) {

        if (isDuplicatedUsername(userJoinRequestDto.getUsername())) {
            throw new BusinessException(UserExceptionType.DUPLICATED_USERNAME);
        }

        User user = new User(userJoinRequestDto.getUsername(),
                userJoinRequestDto.getName(),
                userJoinRequestDto.getPassword(),
                userJoinRequestDto.getProfileImage(),
                userJoinRequestDto.getLoginType());

        return userRepository.save(user);
    }

    public boolean isDuplicatedUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User findById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(UserExceptionType.NOT_FOUND));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void doesExist(long userId) {
        if (!userRepository.existsById(userId)) {
            throw new BusinessException(UserExceptionType.NOT_FOUND);
        }
    }

    public UserResponseDto findUserInfo(long userId) {
        return UserResponseDto.from(findById(userId));

    }
}
