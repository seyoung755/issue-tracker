package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

@Getter
public class IssueLabelEditRequestDto {

    private String toAdd;
    private String toDelete;
}
