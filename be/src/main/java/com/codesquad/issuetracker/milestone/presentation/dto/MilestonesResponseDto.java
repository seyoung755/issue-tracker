package com.codesquad.issuetracker.milestone.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class MilestonesResponseDto {

    private List<MilestoneResponseDto> milestones;

    public MilestonesResponseDto(List<MilestoneResponseDto> milestones) {
        this.milestones = milestones;
    }
}
