package com.codesquad.issuetracker.milestone.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.milestone.application.MilestoneService;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneCountDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneSaveRequestDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestonesResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/milestones")
@RestController
public class MilestoneController {

    private final MilestoneService milestoneService;

    @Operation(summary = "마일스톤 목록 조회하기", description = "모든 마일스톤 목록을 보여줍니다.")
    @GetMapping
    public MilestonesResponseDto readList() {
        return milestoneService.findAll();
    }

    @GetMapping("/count")
    @Operation(summary = "마일스톤 개수 조회하기", description = "현재 마일스톤의 개수를 출력합니다.")
    public MilestoneCountDto getCount() {
        return milestoneService.count();
    }

    @Operation(summary = "마일스톤 작성하기", description = "새로운 마일스톤을 추가합니다.")
    @PostMapping
    public long save(@RequestBody MilestoneSaveRequestDto milestoneSaveRequestDto) {
        return milestoneService.save(milestoneSaveRequestDto);
    }

    @Operation(summary = "마일스톤 편집하기", description = "마일스톤의 정보를 편집합니다.")
    @PutMapping("/{milestoneId}")
    public MilestoneResponseDto edit(@PathVariable long milestoneId,
                                     @RequestBody MilestoneSaveRequestDto milestoneSaveRequestDto) {
        return null;
    }

    @Operation(summary = "마일스톤 삭제하기", description = "선택한 마일스톤을 삭제합니다.")
    @DeleteMapping("/{milestoneId}")
    public long delete(@PathVariable long milestoneId) {
        return 1L;
    }
}
