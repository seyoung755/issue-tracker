package com.codesquad.issuetracker.issue.application.dto;

import lombok.Getter;

@Getter
public class IssueMilestoneEditDto {

    private long issueId;
    private String milestoneName;

    public IssueMilestoneEditDto(long issueId, String milestoneName) {
        this.issueId = issueId;
        this.milestoneName = milestoneName;
    }
}
