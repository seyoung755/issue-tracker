package com.codesquad.issuetracker.milestone.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MilestoneCountDto {

    private long count;

    public MilestoneCountDto(long count) {
        this.count = count;
    }
}
