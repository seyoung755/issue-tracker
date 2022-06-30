package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IssueMilestoneEditRequestDto {

    private String milestoneName;

    public IssueMilestoneEditRequestDto(String milestoneName) {
        this.milestoneName = milestoneName;
    }
}
