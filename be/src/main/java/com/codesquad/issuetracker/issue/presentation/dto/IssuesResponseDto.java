package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.Issue;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class IssuesResponseDto {

    private List<IssueResponseDto> issues;
    private long openCount;
    private long closeCount;

    private IssuesResponseDto(List<IssueResponseDto> issues, long openCount, long closeCount) {
        this.issues = issues;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }

    public static IssuesResponseDto of(List<Issue> issues, long openCount, long closeCount) {

        List<IssueResponseDto> issueResponseDtos = issues.stream()
                .map(IssueResponseDto::from)
                .collect(Collectors.toList());

        return new IssuesResponseDto(issueResponseDtos, openCount, closeCount);
    }
}
