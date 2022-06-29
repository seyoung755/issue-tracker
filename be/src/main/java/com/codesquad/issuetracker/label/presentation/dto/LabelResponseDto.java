package com.codesquad.issuetracker.label.presentation.dto;

import com.codesquad.issuetracker.label.domain.Label;
import com.codesquad.issuetracker.label.domain.TextColor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LabelResponseDto {

    private String labelName;
    private String description;
    private String colorCode;
    private TextColor textColor;

    public LabelResponseDto(String labelName, String description, String colorCode, TextColor textColor) {
        this.labelName = labelName;
        this.description = description;
        this.colorCode = colorCode;
        this.textColor = textColor;
    }

    public static LabelResponseDto from(Label label) {
        return new LabelResponseDto(label.getLabelName(), label.getDescription(), label.getColorCode(), label.getTextColor());
    }
}
