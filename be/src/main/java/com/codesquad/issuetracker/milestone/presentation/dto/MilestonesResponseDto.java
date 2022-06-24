package com.codesquad.issuetracker.milestone.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MilestonesResponseDto {

    private List<SingleMilestoneResponseDto> milestones;
}
