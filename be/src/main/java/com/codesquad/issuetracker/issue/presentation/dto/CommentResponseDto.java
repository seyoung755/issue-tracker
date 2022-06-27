package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private String content;
    private AuthorInformationDto author;
    private LocalDateTime createdAt;

}
