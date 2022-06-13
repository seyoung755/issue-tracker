package com.codesquad.issuetracker.issue.presentation.controller;

import com.codesquad.issuetracker.issue.presentation.dto.FilteringCondition;
import com.codesquad.issuetracker.issue.presentation.dto.IssuesResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/issues")
@RestController
public class IssueController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "이슈 조회 성공")
    })
    @Operation(summary = "이슈 목록 조회하기", description = "필터링 조건으로 조회한 이슈 목록을 보여줍니다.")
    @GetMapping
    public IssuesResponseDto listOfOpen(FilteringCondition filteringCondition) {

        return null;
    }
}
