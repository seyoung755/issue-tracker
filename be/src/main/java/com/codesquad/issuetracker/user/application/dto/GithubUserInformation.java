package com.codesquad.issuetracker.user.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GithubUserInformation {

    @JsonProperty(value = "login")
    private String userId;

    @JsonProperty(value = "name")
    private String username;

    @JsonProperty(value = "node_id")
    private String password;

    @JsonProperty(value = "avatar_url")
    private String profileImage;

    public GithubUserInformation(String userId, String username, String password, String profileImage) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }
}
