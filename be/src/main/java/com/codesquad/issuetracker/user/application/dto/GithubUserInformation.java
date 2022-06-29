package com.codesquad.issuetracker.user.application.dto;

import com.codesquad.issuetracker.user.domain.LoginType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GithubUserInformation extends OAuthUserInformation {

    private final LoginType loginType = LoginType.GITHUB;

    @JsonProperty(value = "id")
    private String username;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "node_id")
    private String password;

    @JsonProperty(value = "avatar_url")
    private String profileImage;

    public GithubUserInformation(String username, String name, String password, String profileImage) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
