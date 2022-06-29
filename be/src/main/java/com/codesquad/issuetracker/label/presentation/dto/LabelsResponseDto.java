package com.codesquad.issuetracker.label.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class LabelsResponseDto {

    private List<LabelResponseDto> labels;

    public LabelsResponseDto(List<LabelResponseDto> labels) {
        this.labels = labels;
    }
}
