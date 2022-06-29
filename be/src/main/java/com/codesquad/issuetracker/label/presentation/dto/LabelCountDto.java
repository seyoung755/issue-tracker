package com.codesquad.issuetracker.label.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LabelCountDto {

    private int count;

    public LabelCountDto(int count) {
        this.count = count;
    }
}
