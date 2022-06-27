package com.codesquad.issuetracker.user.application.dto;

import com.codesquad.issuetracker.user.domain.LoginType;
import lombok.Getter;

@Getter
public abstract class OAuthUserInformation {

    private String username;
    private String name;
    private String password;
    private String profileImage;
    private LoginType loginType;
}
