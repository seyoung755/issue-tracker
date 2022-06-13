package com.codesquad.issuetracker.label.presentation.controller;

import com.codesquad.issuetracker.label.presentation.dto.LabelCountDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/labels")
@RestController
public class LabelController {

    @Operation(summary = "라벨 목록 조회하기", description = "모든 라벨의 목록을 보여줍니다.")
    @GetMapping
    public LabelsResponseDto list() {
        return null;
    }

    @Operation(summary = "라벨 개수 조회하기", description = "현재 라벨의 개수를 출력합니다.")
    @GetMapping("/count")
    public LabelCountDto count() {
        return null;
    }
}
