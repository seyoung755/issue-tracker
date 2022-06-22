package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.user.application.BasicLoginService;
import com.codesquad.issuetracker.user.application.OAuthLoginService;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class LoginController {

    private final OAuthLoginService oAuthLoginService;
    private final BasicLoginService basicLoginService;
    private final String redirectUrl;
    private final String githubRedirectUrl;
    private final String googleRedirectUrl;

    public LoginController(
            @Value("${oauth.redirect_url}") String redirectUrl,
            @Value("${oauth.github.client_id}") String githubClientId,
            @Value("${oauth.google.client_id}") String googleClientId,
            OAuthLoginService oAuthLoginService,
            BasicLoginService basicLoginService) {
        this.oAuthLoginService = oAuthLoginService;
        this.basicLoginService = basicLoginService;
        this.redirectUrl = redirectUrl;
        githubRedirectUrl =
                "https://github.com/login/oauth/authorize?client_id=" + githubClientId + "&scope=user:email";
        googleRedirectUrl =
                "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + googleClientId
                        + "&redirect_uri=" + redirectUrl + "/oauth/google/callback&"
                        + "response_type=code&"
                        + "scope=profile email";
    }

    @Operation(summary = "Github 로그인 화면으로 Redirect 하기", description = "Github 로그인 페이지로 이동합니다.")
    @GetMapping("/oauth/github/login")
    public ResponseEntity<Void> loginByGithub() throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(githubRedirectUrl)).build();
    }

    @Operation(summary = "Github 로그인 처리하기", description = "Github Authorization code 를 받아서 로그인을 완료합니다.")
    @GetMapping("/oauth/github/callback")
    public LoginResponseDto receiveCallbackFromGithub(@RequestParam String code) {
        return oAuthLoginService.githubLogin(code);
    }

    @Operation(summary = "Google 로그인 화면으로 Redirect 하기", description = "Google 로그인 페이지로 이동합니다.")
    @GetMapping("/oauth/google/login")
    public ResponseEntity<Void> loginByGoogle() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", googleRedirectUrl).build();
    }

    @Operation(summary = "Google 로그인 처리하기", description = "Google Authorization code 를 받아서 로그인을 완료합니다.")
    @GetMapping("/oauth/google/callback")
    public LoginResponseDto receiveCallbackFromGoogle(@RequestParam String code) {
        log.debug("LoginController Google login code: {}", code);
        return oAuthLoginService.googleLogin(code);
    }

    @Operation(summary = "유저 로그인하기", description = "사용자의 로그인을 처리합니다.")
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return basicLoginService.login(userLoginRequestDto);
    }

    @Operation(summary = "유저 로그아웃하기", description = "사용자의 로그아웃을 처리합니다.")
    @GetMapping("/logout")
    public void logout(@Auth User user) {
        basicLoginService.logout(user);
    }

}
