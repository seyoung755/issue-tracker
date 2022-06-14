package com.codesquad.issuetracker.milestone.presentation.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MilestoneFormDto {

    private String name;
    private LocalDate dueDate;
    private String description;
}
