package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.IssueStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilteringCondition {

    private IssueStatus issueStatus;
    private String labelName;
    private String milestoneName;
    private Long authorId;
    private String assignee;
    private String commentAuthor;

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = IssueStatus.from(issueStatus);
    }
}
