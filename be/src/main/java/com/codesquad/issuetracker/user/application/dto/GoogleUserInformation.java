package com.codesquad.issuetracker.user.application.dto;


import com.codesquad.issuetracker.user.domain.LoginType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoogleUserInformation extends OAuthUserInformation {

    private final LoginType loginType = LoginType.GOOGLE;

    @JsonProperty(value = "email")
    private String username;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "id")
    private String password;

    @JsonProperty(value = "picture")
    private String profileImage;

    public GoogleUserInformation(String username, String name, String password, String profileImage) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
    }
}
