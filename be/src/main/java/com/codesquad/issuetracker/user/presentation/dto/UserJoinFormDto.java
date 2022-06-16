package com.codesquad.issuetracker.user.presentation.dto;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@Getter
public class UserJoinFormDto {

    private String username;

    @Size(min = 4, message = "아이디 형식이 올바르지 않습니다.")
    private String userId;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}", message = "비밀번호 형식이 올바르지 않습니다.")
    private String password;

    private String profileImage;
}
