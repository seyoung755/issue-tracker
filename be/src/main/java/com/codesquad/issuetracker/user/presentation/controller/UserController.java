package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.user.application.UserService;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinRequestDto;
import com.codesquad.issuetracker.user.presentation.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "유저 회원가입하기", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/join")
    public ResponseEntity<Void> join(@Valid @RequestBody UserJoinRequestDto userJoinRequestDto) {
        userJoinRequestDto.setLoginType(LoginType.NORMAL);
        userService.join(userJoinRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "유저 Id의 중복 여부 검사하기", description = "유저 Id의 중복 여부를 검사합니다.")
    @PostMapping("/join/checkId")
    public ResponseEntity<Boolean> checkDuplicateId(@RequestBody String userId) {
        return ResponseEntity.ok().body(userService.isDuplicatedUsername(userId));
    }

    @Operation(summary = "유저 정보 조회하기", description = "유저의 정보를 조회합니다.")
    @GetMapping("/info")
    public ResponseEntity<UserResponseDto> getUserInfo(@Auth Long userId) {
        return ResponseEntity.ok().body(userService.findUserInfo(userId));
    }
}
