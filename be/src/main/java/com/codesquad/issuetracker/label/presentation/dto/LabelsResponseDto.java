package com.codesquad.issuetracker.label.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LabelsResponseDto {

    private List<LabelResponseDto> labels;

}
