package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssuesResponseDto {

    private List<SingleIssueResponseDto> issues;
    private int openCount;
    private int closeCount;
}
