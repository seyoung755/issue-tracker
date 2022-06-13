package com.codesquad.issuetracker.milestone.presentation.controller;

import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneCountDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestonesResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/milestones")
@RestController
public class MilestoneController {

    @Operation(summary = "마일스톤 목록 조회하기", description = "모든 마일스톤 목록을 보여줍니다.")
    @GetMapping
    public MilestonesResponseDto list() {
        return null;
    }

    @GetMapping("/count")
    @Operation(summary = "마일스톤 개수 조회하기", description = "현재 마일스톤의 개수를 출력합니다.")
    public MilestoneCountDto count() {
        return null;
    }
}
