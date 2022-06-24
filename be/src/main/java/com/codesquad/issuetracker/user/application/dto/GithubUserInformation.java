package com.codesquad.issuetracker.user.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GithubUserInformation {


    @JsonProperty(value = "login")
    private final String userId;

    @JsonProperty(value = "name")
    private final String username;

    @JsonProperty(value = "node_id")
    private final String password;

    @JsonProperty(value = "avatar_url")
    private final String profileImage;

    public GithubUserInformation(String userId, String username, String password, String profileImage) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }
}
