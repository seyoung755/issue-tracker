package com.codesquad.issuetracker.user.presentation.controller;

import com.codesquad.issuetracker.user.presentation.dto.UserJoinFormDto;
import com.codesquad.issuetracker.user.presentation.dto.LoginResponseDto;
import com.codesquad.issuetracker.user.presentation.dto.UserLoginFormDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public LoginResponseDto login(UserLoginFormDto userLoginFormDto) {
        return null;
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(UserJoinFormDto userJoinFormDto) {
        return ResponseEntity.ok().build();
    }

}
