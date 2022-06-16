package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.application.OAuthService;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@RequestMapping("/oauth/login")
@RestController
public class OAuthController {

    private static final String GITHUB_REDIRECT_URL =
            "https://github.com/login/oauth/authorize?client_id=fbfd3db42dc5b227d1b8&scope=user:email";

    private final OAuthService oAuthService;

    @GetMapping()
    public ResponseEntity<Void> login() throws URISyntaxException {
        /**
         * todo: 이미 토큰을 들고 있을 때 유효한 토큰이면, redirect를 거치지 않고 바로 로그인 처리
         * LoginInterceptor를 별도로 구현해서 유효할 경우 인터셉터에서 바로 false를 주고 요청을 끝내야할까?
         */
        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(GITHUB_REDIRECT_URL)).build();
    }

    @GetMapping("/callback")
    public LoginResponseDto oauth(@RequestParam String code) {
        return oAuthService.login(code);
    }
}
