package com.codesquad.issuetracker.issue.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AssigneesInformationDto {

    private List<SingleAssigneeResponseDto> assignees;
}
