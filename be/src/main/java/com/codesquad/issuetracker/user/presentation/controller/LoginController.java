package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.user.application.BasicLoginService;
import com.codesquad.issuetracker.user.application.OAuthLoginService;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final OAuthLoginService oAuthLoginService;
    private final BasicLoginService basicLoginService;

    @Operation(summary = "Github 로그인 화면으로 Redirect 하기", description = "Github 로그인 페이지로 이동합니다.")
    @GetMapping("/oauth/{platform}/login")
    public ResponseEntity<String> oauthLogin(@PathVariable String platform) {
        LoginType loginType = LoginType.valueOf(platform.toUpperCase());
        return ResponseEntity.ok().body(oAuthLoginService.getRedirectUrl(loginType));
    }

    @Operation(summary = "Github 로그인 처리하기", description = "Github Authorization code 를 받아서 로그인을 완료합니다.")
    @GetMapping("/oauth/{platform}/callback")
    public LoginResponseDto receiveCallback(@RequestParam String code, @PathVariable String platform) {
        LoginType loginType = LoginType.valueOf(platform.toUpperCase());
        return oAuthLoginService.login(code, loginType);
    }

    @Operation(summary = "유저 로그인하기", description = "사용자의 로그인을 처리합니다.")
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return basicLoginService.login(userLoginRequestDto);
    }

    @Operation(summary = "유저 로그아웃하기", description = "사용자의 로그아웃을 처리합니다.")
    @GetMapping("/logout")
    public void logout(@Auth Long userId) {
        basicLoginService.logout(userId);
    }

}
