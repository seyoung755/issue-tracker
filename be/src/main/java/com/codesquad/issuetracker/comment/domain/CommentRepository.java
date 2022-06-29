package com.codesquad.issuetracker.comment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository {

    @Query("select c from Comment c join fetch c.user where c.issue.id = :issueId and c.isDeleted = :isDeleted")
    List<Comment> findAllByIssueIdAndIsDeleted(long issueId, boolean isDeleted);

    @Query("select c from Comment c join fetch c.issue where c.issue.user.id = c.user.id and c.issue.id = :issueId")
    List<Comment> findAllAuthorComment(long issueId);
}

