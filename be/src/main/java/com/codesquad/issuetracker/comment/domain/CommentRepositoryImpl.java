package com.codesquad.issuetracker.comment.domain;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.codesquad.issuetracker.comment.domain.QComment.comment;
import static com.codesquad.issuetracker.issue.domain.QIssue.issue;
import static com.codesquad.issuetracker.user.domain.QUser.user;


@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentCustomRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Comment> findAllByIssueId(long issueId) {
        return query.select(comment)
                .from(comment)
                .join(comment.user, user).fetchJoin()
                .join(comment.issue, issue).fetchJoin()
                .where(id(issueId),
                        isNotDeleted())
                .fetch();
    }

    private BooleanExpression id(long issueId) {
        return issue.id.eq(issueId);
    }

    private BooleanExpression isNotDeleted() {
        return issue.isDeleted.eq(false);
    }

}
