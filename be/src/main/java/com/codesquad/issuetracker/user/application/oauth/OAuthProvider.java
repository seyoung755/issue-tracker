package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import com.codesquad.issuetracker.user.domain.LoginType;
import org.springframework.stereotype.Service;

@Service
public interface OAuthProvider {

    LoginType getOAuthType();

    String getRedirectUrl();

    OAuthUserInformation requestUserInformation(String code);


}
