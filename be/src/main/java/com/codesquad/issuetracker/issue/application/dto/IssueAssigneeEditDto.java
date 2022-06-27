package com.codesquad.issuetracker.issue.application.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueAssigneeEditDto {

    private long issueId;
    private List<Long> assignees;

    public IssueAssigneeEditDto(long issueId, List<Long> assignees) {
        this.issueId = issueId;
        this.assignees = assignees;
    }
}
