package com.codesquad.issuetracker.comment.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CommentsResponseDto {

    private List<CommentResponseDto> comments = new ArrayList<>();

    public CommentsResponseDto(List<CommentResponseDto> comments) {
        this.comments = comments;
    }
}
