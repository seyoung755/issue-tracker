package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IssueTitleEditRequestDto {

    private String title;

    public IssueTitleEditRequestDto(String title) {
        this.title = title;
    }
}
