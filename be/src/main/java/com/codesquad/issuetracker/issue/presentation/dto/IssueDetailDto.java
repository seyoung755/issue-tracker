package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.label.presentation.dto.LabelResponseDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelsResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class IssueDetailDto {

    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private AuthorInformationDto author;
    private List<AssigneeResponseDto> assignees;
    private LabelsResponseDto labels;
    private MilestoneResponseDto milestone;

    private IssueDetailDto(long id, String title, String content, LocalDateTime createdAt, AuthorInformationDto author,
                          List<AssigneeResponseDto> assignees, LabelsResponseDto labels, MilestoneResponseDto milestone) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author;
        this.assignees = assignees;
        this.labels = labels;
        this.milestone = milestone;
    }

    public static IssueDetailDto from(Issue issue) {

        LabelsResponseDto labels = new LabelsResponseDto(
                issue.getLabels().stream()
                        .map(issueLabel -> LabelResponseDto.from(issueLabel.getLabel()))
                        .collect(Collectors.toList()));

        List<AssigneeResponseDto> assignees = issue.getAssignees().stream()
                .map(issueAssignee -> AssigneeResponseDto.from(issueAssignee.getAssignee()))
                .collect(Collectors.toList());

        return new IssueDetailDto(
                issue.getId(),
                issue.getTitle(),
                issue.getContent(),
                issue.getCreatedAt(),
                AuthorInformationDto.from(issue.getUser()),
                assignees,
                labels,
                MilestoneResponseDto.from(issue.getMilestone()));
    }
}
