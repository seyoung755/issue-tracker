package com.codesquad.issuetracker.user.domain;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.ExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public User(String username, String name, String password, String profileImage) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
    }

    public void validatePassword(String password) {
        if (!this.password.equals(password)) {
            throw new BusinessException(UserExceptionType.INVALID_PASSWORD);
        }
    }
}


