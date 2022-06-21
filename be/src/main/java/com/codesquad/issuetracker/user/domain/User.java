package com.codesquad.issuetracker.user.domain;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String password;
    private String profileImage;
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    public User(String username, String name, String password, String profileImage, LoginType loginType) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
        this.loginType = loginType;
    }

    public void validatePassword(String password) {
        if (!this.password.equals(password)) {
            throw new BusinessException(UserExceptionType.INVALID_PASSWORD);
        }
    }

    public void saveRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}


