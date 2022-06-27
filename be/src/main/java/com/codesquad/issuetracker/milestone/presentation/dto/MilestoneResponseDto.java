package com.codesquad.issuetracker.milestone.presentation.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MilestoneResponseDto {

    private String name;
    private LocalDate dueDate;
    private String description;
    private double progressRate;
    private int openCount;
    private int closeCount;
}
