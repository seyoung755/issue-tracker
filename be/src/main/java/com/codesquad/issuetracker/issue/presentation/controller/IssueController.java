package com.codesquad.issuetracker.issue.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.issue.application.IssueService;
import com.codesquad.issuetracker.issue.presentation.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/issues")
@RestController
public class IssueController {

    private final IssueService issueService;

    @Operation(summary = "이슈 상세정보 조회하기", description = "이슈의 상세정보를 조회합니다.")
    @GetMapping("/{id}")
    public IssueDetailDto readDetail(@PathVariable(value = "id") long issueId) {
        return null;
    }

    @Operation(summary = "이슈 목록 조회하기", description = "필터링 조건으로 조회한 이슈 목록을 보여줍니다.")
    @GetMapping
    public IssuesResponseDto readListOfOpen(FilteringCondition filteringCondition) {

        return null;
    }

    @Operation(summary = "이슈 작성하기", description = "새로운 이슈를 작성합니다.")
    @PostMapping
    public long write(@Auth Long userId, @RequestBody IssueSaveRequestDto issueSaveRequestDto) {
        return issueService.save(userId, issueSaveRequestDto);
    }

    @Operation(summary = "이슈의 제목을 편집하기", description = "기존 이슈의 제목을 편집합니다.")
    @PutMapping("/title/{id}")
    public ResponseEntity<Void> editTitle(@Auth Long userId,
                                          @PathVariable(value = "id") long issueId,
                                          @RequestBody IssueTitleEditRequestDto issueTitleEditRequestDto) {
        issueService.editTitle(issueId, issueTitleEditRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이슈의 내용을 편집하기", description = "기존 이슈의 내용을 편집합니다.")
    @PutMapping("/content/{id}")
    public ResponseEntity<Void> editContent(@PathVariable(value = "id") long issueId,
                                            @RequestBody IssueContentEditRequestDto issueContentEditRequestDto) {
        issueService.editContent(issueId, issueContentEditRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이슈의 담당자를 편집하기", description = "기존 이슈의 담당자를 추가하거나 삭제합니다.")
    @PutMapping("/assignee/{id}")
    public ResponseEntity<Void> editAssignee(@PathVariable(value = "id") long issueId,
                                             @RequestBody IssueAssigneeEditRequestDto issueAssigneeEditRequestDto) {
        issueService.editAssignee(issueId, issueAssigneeEditRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이슈의 라벨을 편집하기", description = "기존 이슈의 라벨을 추가하거나 삭제합니다.")
    @PutMapping("/label/{id}")
    public ResponseEntity<Void> editLabel(@PathVariable(value = "id") long issueId,
                                          @RequestBody IssueLabelEditRequestDto issueLabelEditRequestDto) {
        issueService.editLabels(issueId, issueLabelEditRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이슈의 마일스톤을 편집하기", description = "기존 이슈의 마일스톤을 추가하거나 삭제합니다.")
    @PutMapping("/milestone/{id}")
    public ResponseEntity<Void> editMilestone(@PathVariable(value = "id") long issueId,
                                              @RequestBody IssueMilestoneEditRequestDto issueMileStoneEditRequestDto) {
        issueService.editMilestone(issueId, issueMileStoneEditRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이슈 삭제하기", description = "이슈를 삭제합니다.")
    @DeleteMapping("/{id}")
    public long delete(@PathVariable(value = "id") long issueId) {
        return issueService.softDelete(issueId);
    }
}
