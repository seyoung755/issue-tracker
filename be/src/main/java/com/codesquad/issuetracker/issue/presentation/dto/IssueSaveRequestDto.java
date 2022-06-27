package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueSaveRequestDto {

    private String title;
    private String content;
    private List<Long> assignees;
    private List<String> labelNames;
    private String milestoneName;

}
