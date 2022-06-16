package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.application.UserService;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserJoinFormDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginFormDto;
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

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody UserLoginFormDto userLoginFormDto) {
        return userService.login(userLoginFormDto);
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(@Validated @RequestBody UserJoinFormDto userJoinFormDto) {
        userService.join(userJoinFormDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/join/checkId")
    public ResponseEntity<Boolean> checkDuplicateId(@RequestBody String userId) {
        return ResponseEntity.ok().body(userService.isDuplicatedUserId(userId));
    }

}
