package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueFormDto {

    private String title;
    private String content;
    private List<String> assignees;
    private String labelName;
    private String milestoneName;
}
