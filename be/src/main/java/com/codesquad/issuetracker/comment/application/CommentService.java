package com.codesquad.issuetracker.comment.application;

import com.codesquad.issuetracker.comment.domain.Comment;
import com.codesquad.issuetracker.comment.domain.CommentRepository;
import com.codesquad.issuetracker.comment.presentation.dto.CommentResponseDto;
import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.CommentExceptionType;
import com.codesquad.issuetracker.exception.domain.type.IssueExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.issue.domain.IssueRepository;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentService {

    private final UserRepository userRepository;
    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;

    public List<CommentResponseDto> findAllComments(long issueId) {
        List<Comment> comments = commentRepository.findAllByIssueId(issueId);
        return comments.stream()
                .map(CommentResponseDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public long writeComment(long userId, long issueId, String content) {
        User user = findUser(userId);
        Issue issue = findIssue(issueId);
        Comment comment = new Comment(content, user, issue);
        commentRepository.save(comment);

        return comment.getId();
    }

    @Transactional
    public void editComment(long commentId, String content) {
        Comment comment = findComment(commentId);
        comment.updateContent(content);
    }

    @Transactional
    public void deleteComment(long commentId) {
        Comment comment = findComment(commentId);
        comment.delete();
    }

    private User findUser(long userId) {
        return userRepository.findByIdAndIsDeleted(userId, false)
                .orElseThrow(() -> new BusinessException(UserExceptionType.NOT_FOUND));
    }

    private Issue findIssue(long issueId) {
        return issueRepository.findByIdAndIsDeleted(issueId, false)
                .orElseThrow(() -> new BusinessException(IssueExceptionType.NOT_FOUND));
    }

    private Comment findComment(long commentId) {
        return commentRepository.findByIdAndIsDeleted(commentId, false)
                .orElseThrow(() -> new BusinessException(CommentExceptionType.NOT_FOUND));
    }

}
