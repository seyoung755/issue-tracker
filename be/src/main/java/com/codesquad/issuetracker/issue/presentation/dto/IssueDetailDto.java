package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.label.presentation.dto.SingleLabelResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.SingleMilestoneResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class IssueDetailDto {

    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private AuthorInformationDto author;
    private List<SingleAssigneeResponseDto> assignees;
    private SingleLabelResponseDto label;
    private SingleMilestoneResponseDto milestone;
    private List<SingleCommentResponseDto> comments;

}
