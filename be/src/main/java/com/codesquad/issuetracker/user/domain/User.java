package com.codesquad.issuetracker.user.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.common.util.PasswordEncryptor;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.AuthExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.issue.domain.Issue;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


