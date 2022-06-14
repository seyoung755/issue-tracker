package com.codesquad.issuetracker.user.presentation.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;

}
