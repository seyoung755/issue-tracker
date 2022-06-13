package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SingleIssueResponseDto {

    private long issueId;
    private int issueNumber;
    private LocalDateTime createdAt;
    private String labelName;
    private String milestoneName;
    private AuthorInformationDto authorInformation;
}
