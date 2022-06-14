package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.label.presentation.dto.SingleLabelResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.SingleMilestoneResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class IssueDetailDto {

    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private AuthorInformationDto author;
    private AssigneesInformationDto assignees;
    private SingleLabelResponseDto label;
    private SingleMilestoneResponseDto milestone;
    private CommentsResponseDto comments;

}
