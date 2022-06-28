package com.codesquad.issuetracker.milestone.presentation.dto;

import com.codesquad.issuetracker.milestone.domain.Milestone;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MilestoneSaveRequestDto {

    private String name;
    private LocalDate dueDate;
    private String description;

    public Milestone toEntity() {
        return new Milestone(name, dueDate, description);
    }
}
