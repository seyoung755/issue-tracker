package com.codesquad.issuetracker.milestone.presentation.dto;

import com.codesquad.issuetracker.milestone.domain.Milestone;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class MilestoneSaveRequestDto {

    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dueDate;
    private String description;

    public Milestone toEntity() {
        return new Milestone(name, dueDate, description);
    }
}
