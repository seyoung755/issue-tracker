package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class IssueSaveRequestDto {

    private String title;
    private String content;
    private List<Long> assignees;
    private List<String> labelNames;
    private String milestoneName;

    public IssueSaveRequestDto(String title, String content, List<Long> assignees, List<String> labelNames, String milestoneName) {
        this.title = title;
        this.content = content;
        this.assignees = assignees;
        this.labelNames = labelNames;
        this.milestoneName = milestoneName;
    }
}
