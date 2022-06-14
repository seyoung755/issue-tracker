package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueAssigneeEditRequestDto {

    private List<String> toAdd;
    private List<String> toDelete;
}
