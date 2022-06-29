package com.codesquad.issuetracker.label.presentation.controller;

import com.codesquad.issuetracker.label.application.LabelService;
import com.codesquad.issuetracker.label.presentation.dto.LabelCountDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelSaveRequestDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelsResponseDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/labels")
@RestController
public class LabelController {

    private final LabelService labelService;

    @Operation(summary = "라벨 목록 조회하기", description = "모든 라벨의 목록을 보여줍니다.")
    @GetMapping
    public LabelsResponseDto readList() {
        return labelService.findAll();
    }

    @Operation(summary = "라벨 개수 조회하기", description = "현재 라벨의 개수를 출력합니다.")
    @GetMapping("/count")
    public LabelCountDto getCount() {
        return labelService.count();
    }

    @Operation(summary = "라벨 작성하기", description = "새로운 라벨을 추가합니다.")
    @PostMapping
    public long save(@RequestBody LabelSaveRequestDto labelSaveRequestDto) {
        return labelService.save(labelSaveRequestDto);
    }

    @Operation(summary = "라벨 편집하기", description = "라벨의 정보를 편집합니다.")
    @PutMapping("/{labelId}")
    public LabelResponseDto edit(@PathVariable long labelId, @RequestBody LabelSaveRequestDto labelSaveRequestDto) {
        return labelService.edit(labelId, labelSaveRequestDto);
    }

    @Operation(summary = "라벨 삭제하기", description = "선택한 라벨을 삭제합니다.")
    @DeleteMapping("/{labelId}")
    public long delete(@PathVariable long labelId) {
        return labelService.softDelete(labelId);
    }
}
