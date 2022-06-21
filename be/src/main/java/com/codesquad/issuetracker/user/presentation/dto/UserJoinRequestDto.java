package com.codesquad.issuetracker.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@NoArgsConstructor
@Getter
public class UserJoinRequestDto {

    @Size(min = 4, message = "아이디 형식이 올바르지 않습니다.")
    private String username;

    private String name;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}", message = "비밀번호 형식이 올바르지 않습니다.")
    private String password;

    private String profileImage;

    public UserJoinRequestDto(String username, String name, String password, String profileImage) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
    }
}
