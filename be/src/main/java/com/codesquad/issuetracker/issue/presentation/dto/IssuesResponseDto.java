package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class IssuesResponseDto {

    private List<IssueResponseDto> issues;
    private long openCount;
    private long closeCount;

    public IssuesResponseDto(List<IssueResponseDto> issues, long openCount, long closeCount) {
        this.issues = issues;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}
