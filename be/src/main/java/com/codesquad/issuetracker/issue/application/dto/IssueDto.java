package com.codesquad.issuetracker.issue.application.dto;

import com.codesquad.issuetracker.issue.presentation.dto.IssueSaveRequestDto;
import lombok.Getter;

import java.util.List;

@Getter
public class IssueDto {

    private Long userId;
    private String title;
    private String content;
    private String milestoneName;
    private List<Long> assignees;
    private List<String> labelNames;

    public IssueDto(Long userId, String title, String content, String milestoneName, List<Long> assignees, List<String> labelNames) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.milestoneName = milestoneName;
        this.assignees = assignees;
        this.labelNames = labelNames;
    }

    public static IssueDto from(long userId, IssueSaveRequestDto issueSaveRequestDto) {
        return new IssueDto(userId,
                issueSaveRequestDto.getTitle(),
                issueSaveRequestDto.getContent(),
                issueSaveRequestDto.getMilestoneName(),
                issueSaveRequestDto.getAssignees(),
                issueSaveRequestDto.getLabelNames());
    }
}
