package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.user.application.dto.GithubUserInformation;
import org.springframework.stereotype.Service;

@Service
public interface OAuthProvider {

    GithubUserInformation requestUserInformation(String code);
}
