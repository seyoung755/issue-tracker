package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.application.OAuthService;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/oauth/login")
@RestController
public class OAuthController {


    public OAuthController(@Value("${oauth.github.client_id") String clientId,
                           OAuthService oAuthService) {
        this.oAuthService = oAuthService;
        redirectUrl =
                "https://github.com/login/oauth/authorize?client_id=" + clientId + "&scope=user:email";

    }

    private final OAuthService oAuthService;
    private final String redirectUrl;

    @Operation(summary = "Github 로그인 화면으로 Redirect 하기", description = "Github 로그인 페이지로 이동합니다.")
    @GetMapping()
    public ResponseEntity<Void> login() throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(redirectUrl)).build();
    }

    @Operation(summary = "Github 로그인 처리하기", description = "Github Authorization code 를 받아서 로그인을 완료합니다.")
    @GetMapping("/callback")
    public LoginResponseDto receiveCallback(@RequestParam String code) {
        return oAuthService.login(code);
    }
}
