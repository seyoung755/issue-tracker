package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class IssueAssigneeEditRequestDto {

    private List<Long> assignees;

    public IssueAssigneeEditRequestDto(List<Long> assignees) {
        this.assignees = assignees;
    }
}
