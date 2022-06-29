package com.codesquad.issuetracker.label.presentation.dto;

import com.codesquad.issuetracker.label.domain.Label;
import com.codesquad.issuetracker.label.domain.TextColor;
import lombok.Getter;

@Getter
public class LabelSaveRequestDto {

    private String labelName;
    private String description;
    private String colorCode;
    private TextColor textColor;

    public Label toEntity() {
        return new Label(labelName, description, colorCode, textColor);
    }
}
