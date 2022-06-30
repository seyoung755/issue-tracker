package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class IssueLabelEditRequestDto {

    private List<String> labelNames;

    public IssueLabelEditRequestDto(List<String> labelNames) {
        this.labelNames = labelNames;
    }
}
