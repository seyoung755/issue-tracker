package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueLabelEditRequestDto {

    private List<String> labelNames;
}
