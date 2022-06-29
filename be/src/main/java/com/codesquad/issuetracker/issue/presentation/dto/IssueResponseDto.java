package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.issue.domain.IssueStatus;
import com.codesquad.issuetracker.label.presentation.dto.LabelResponseDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelsResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class IssueResponseDto {

    private long id;
    private String title;
    private IssueStatus issueStatus;
    private LocalDateTime createdAt;
    private LabelsResponseDto labels;
    private String milestoneName;
    private AuthorInformationDto author;

    public IssueResponseDto(long id, String title, IssueStatus issueStatus, LocalDateTime createdAt, LabelsResponseDto labels, String milestoneName, AuthorInformationDto author) {
        this.id = id;
        this.title = title;
        this.issueStatus = issueStatus;
        this.createdAt = createdAt;
        this.labels = labels;
        this.milestoneName = milestoneName;
        this.author = author;
    }

    public static IssueResponseDto from(Issue issue) {
        List<LabelResponseDto> labelResponseDtos = issue.getLabels().stream()
                .map(issueLabel -> LabelResponseDto.from(issueLabel.getLabel()))
                .collect(Collectors.toList());

        return new IssueResponseDto(
                issue.getId(),
                issue.getTitle(),
                issue.getIssueStatus(),
                issue.getCreatedAt(),
                new LabelsResponseDto(labelResponseDtos),
                issue.getMilestone().getName(),
                AuthorInformationDto.from(issue.getUser()));
    }
}
