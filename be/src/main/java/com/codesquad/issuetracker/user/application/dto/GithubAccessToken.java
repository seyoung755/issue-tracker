package com.codesquad.issuetracker.user.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class GithubAccessToken {

    private String accessToken;
    private String scope;
    private String tokenType;
}
