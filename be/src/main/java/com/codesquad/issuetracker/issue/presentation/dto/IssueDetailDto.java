package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.label.presentation.dto.LabelResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneResponseDto;
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
    private List<AssigneeResponseDto> assignees;
    private LabelResponseDto label;
    private MilestoneResponseDto milestone;
    private List<CommentResponseDto> comments;

}
