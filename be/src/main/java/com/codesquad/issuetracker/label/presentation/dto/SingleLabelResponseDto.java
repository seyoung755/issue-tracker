package com.codesquad.issuetracker.label.presentation.dto;

import lombok.Getter;

@Getter
public class SingleLabelResponseDto {

    private String labelName;
    private String description;
    private String colorCode;
    private String textColor;
}
