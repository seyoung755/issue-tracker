package com.codesquad.issuetracker.issue.application.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueLabelEditDto {

    private long issueId;
    private List<String> labelNames;

    public IssueLabelEditDto(long issueId, List<String> labelNames) {
        this.issueId = issueId;
        this.labelNames = labelNames;
    }
}
