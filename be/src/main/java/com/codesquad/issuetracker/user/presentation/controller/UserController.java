package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.application.UserService;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinFormDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginFormDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "유저 로그인하기", description = "사용자의 로그인을 처리합니다.")
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody UserLoginFormDto userLoginFormDto) {
        return userService.login(userLoginFormDto);
    }

    @Operation(summary = "유저 회원가입하기", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/join")
    public ResponseEntity<Void> join(@Validated @RequestBody UserJoinFormDto userJoinFormDto) {
        userService.join(userJoinFormDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "유저 Id의 중복 여부 검사하기", description = "유저 Id의 중복 여부를 검사합니다.")
    @PostMapping("/join/checkId")
    public ResponseEntity<Boolean> checkDuplicateId(@RequestBody String userId) {
        return ResponseEntity.ok().body(userService.isDuplicatedUserId(userId));
    }

}
