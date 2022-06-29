package com.codesquad.issuetracker.comment.presentation.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CommentRequestDto {

    @Length(min = 1)
    private String content;

}
