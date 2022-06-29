package com.codesquad.issuetracker.comment.presentation.dto;

import com.codesquad.issuetracker.comment.domain.Comment;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private String content;
    private CommentAuthorResponseDto author;
    private LocalDateTime createdAt;

    public CommentResponseDto(String content, CommentAuthorResponseDto author, LocalDateTime createdAt) {
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public static CommentResponseDto from(Comment comment) {
        User author = comment.getUser();
        Issue issue = comment.getIssue();

        boolean isIssueAuthor = issue.getUser().getId() == author.getId();
        return new CommentResponseDto(comment.getContent(),
                CommentAuthorResponseDto.from(author, isIssueAuthor),
                comment.getCreatedAt());
    }
}
