package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.IssueStatus;
import lombok.Getter;

@Getter
public class FilteringCondition {

    private IssueStatus issueStatus;
    private String labelName;
    private String milestoneName;
    private String author;
    private String assignee;
    private String commentAuthor;
}
