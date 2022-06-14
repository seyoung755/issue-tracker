package com.codesquad.issuetracker.user.presentation.dto;

import lombok.Getter;

@Getter
public class UserJoinFormDto {

    private String username;
    //형식 검증
    private String password;
    private String profileImage;
}
