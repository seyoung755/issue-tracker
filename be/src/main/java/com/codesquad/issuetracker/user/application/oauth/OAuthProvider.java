package com.codesquad.issuetracker.user.application.oauth;

import com.codesquad.issuetracker.user.application.dto.OAuthUserInformation;
import org.springframework.stereotype.Service;

@Service
public interface OAuthProvider {

    OAuthUserInformation requestUserInformation(String code);
}
