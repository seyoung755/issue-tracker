package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.IssueStatus;
import lombok.Getter;

@Getter
public class IssueStatusDto {

    private IssueStatus status;
}
