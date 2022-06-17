package com.codesquad.issuetracker.label.presentation.dto;

import com.codesquad.issuetracker.label.domain.TextColor;
import lombok.Getter;

@Getter
public class LabelFormDto {

    private String labelName;
    private String description;
    private String colorCode;
    private TextColor textColor;
}
