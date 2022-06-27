package com.codesquad.issuetracker.user.presentation.dto;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {

    private String username;
    private String password;
}
