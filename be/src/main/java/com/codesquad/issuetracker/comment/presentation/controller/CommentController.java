package com.codesquad.issuetracker.comment.presentation.controller;

import com.codesquad.issuetracker.comment.presentation.dto.CommentResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/issues/{issueId}/comments")
@RestController
public class CommentController {

    @Operation(summary = "댓글 작성하기", description = "새로운 댓글을 작성합니다.")
    @PostMapping
    public long write(@PathVariable long issueId, @RequestBody String content) {
        return 1L;
    }

    @Operation(summary = "댓글 편집하기", description = "댓글의 내용을 편집합니다.")
    @PutMapping("/{commentId}")
    public CommentResponseDto edit(@PathVariable long issueId,
                                   @PathVariable long commentId,
                                   @RequestBody String content) {
        return null;
    }
}
