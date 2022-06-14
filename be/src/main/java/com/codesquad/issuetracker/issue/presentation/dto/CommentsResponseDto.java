package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CommentsResponseDto {

    private List<SingleCommentResponseDto> comments;
}
