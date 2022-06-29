package com.codesquad.issuetracker.comment.presentation.controller;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.Auth;
import com.codesquad.issuetracker.comment.application.CommentService;
import com.codesquad.issuetracker.comment.presentation.dto.CommentRequestDto;
import com.codesquad.issuetracker.comment.presentation.dto.CommentsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/issues/{issueId}/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "댓글 조회하기", description = "이슈의 댓글을 조회합니다.")
    @GetMapping
    public CommentsResponseDto getComments(@PathVariable long issueId) {
        return new CommentsResponseDto(commentService.findAllComments(issueId));
    }

    @Operation(summary = "댓글 작성하기", description = "새로운 댓글을 작성합니다.")
    @PostMapping
    public long write(
            @Auth Long userId,
            @PathVariable long issueId,
            @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.writeComment(userId, issueId, commentRequestDto.getContent());
    }

    @Operation(summary = "댓글 편집하기", description = "댓글의 내용을 편집합니다.")
    @PutMapping("/{commentId}")
    public ResponseEntity<Void> edit(@PathVariable long commentId,
                               @RequestBody @Valid CommentRequestDto commentRequestDto) {
        commentService.editComment(commentId, commentRequestDto.getContent());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 삭제하기", description = "댓글을 삭제합니다.")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

}
