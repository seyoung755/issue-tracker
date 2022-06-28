package com.codesquad.issuetracker.milestone.presentation.dto;

import com.codesquad.issuetracker.milestone.domain.MilestoneInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class MilestoneResponseDto {

    private String name;
    private LocalDate dueDate;
    private String description;
    private double progressRate;
    private long openCount;
    private long closeCount;

    public MilestoneResponseDto(String name, LocalDate dueDate, String description, MilestoneInformation milestoneInformation) {
        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
        this.progressRate = milestoneInformation.getProgressRate();
        this.openCount = milestoneInformation.getOpenCount();
        this.closeCount = milestoneInformation.getCloseCount();
    }
}
