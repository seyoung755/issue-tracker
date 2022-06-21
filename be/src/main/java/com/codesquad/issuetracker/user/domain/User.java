package com.codesquad.issuetracker.user.domain;

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
            //todo : 비밀번호 불일치 익셉션으로 변경해야함.
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}


