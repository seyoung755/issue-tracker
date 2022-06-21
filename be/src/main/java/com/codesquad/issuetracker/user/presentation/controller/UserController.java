package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.application.UserService;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginRequestDto;
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
    public LoginResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

    @Operation(summary = "유저 회원가입하기", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/join")
    public ResponseEntity<Void> join(@Validated @RequestBody UserJoinRequestDto userJoinRequestDto) {
        userService.join(userJoinRequestDto, LoginType.NORMAL);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "유저 Id의 중복 여부 검사하기", description = "유저 Id의 중복 여부를 검사합니다.")
    @PostMapping("/join/checkId")
    public ResponseEntity<Boolean> checkDuplicateId(@RequestBody String userId) {
        return ResponseEntity.ok().body(userService.isDuplicatedUsername(userId));
    }

}
