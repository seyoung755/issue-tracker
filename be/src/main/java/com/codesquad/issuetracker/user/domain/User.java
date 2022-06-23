package com.codesquad.issuetracker.user.domain;

import com.codesquad.issuetracker.common.util.PasswordEncryptor;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Getter
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
        this.password = PasswordEncryptor.hashPassword(password);
        this.profileImage = profileImage;
        this.loginType = loginType;
    }

    public void validatePassword(String plainTextPassword) {
        if (!PasswordEncryptor.checkPassword(plainTextPassword, password)) {
            throw new BusinessException(UserExceptionType.INVALID_PASSWORD);
        }
    }

    public void saveRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public void validateRefreshToken(String refreshToken) {
        if (!this.refreshToken.equals(refreshToken)) {
            throw new BusinessException(AuthExceptionType.INVALID_REFRESH_TOKEN);
        }
    }

    public void expireRefreshToken() {
        this.refreshToken = "";
    }
}


