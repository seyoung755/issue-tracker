package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IssueContentEditRequestDto {

    private String content;

    public IssueContentEditRequestDto(String content) {
        this.content = content;
    }
}
