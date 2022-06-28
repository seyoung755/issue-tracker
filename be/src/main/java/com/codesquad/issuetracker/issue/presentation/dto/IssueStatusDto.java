package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.IssueStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class IssueStatusDto {

    private IssueStatus status;
    private List<Long> issues;
}
