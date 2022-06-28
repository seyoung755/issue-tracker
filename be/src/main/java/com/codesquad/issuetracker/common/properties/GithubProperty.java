package com.codesquad.issuetracker.common.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.github")
public class GithubProperty {

    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;
    private final String accessTokenUrl;
    private final String resourceUrl;

    public GithubProperty(String clientId, String clientSecret, String redirectUrl, String accessTokenUrl, String resourceUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.resourceUrl = resourceUrl;
    }
}
