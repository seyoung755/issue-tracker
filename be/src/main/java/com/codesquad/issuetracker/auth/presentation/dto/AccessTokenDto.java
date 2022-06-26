package com.codesquad.issuetracker.auth.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessTokenDto {

    private String accessToken;

    public AccessTokenDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
