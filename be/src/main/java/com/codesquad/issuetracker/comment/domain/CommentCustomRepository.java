package com.codesquad.issuetracker.comment.domain;

import java.util.List;

public interface CommentCustomRepository {


    List<Comment> findAllByIssueId(long issueId);
}
