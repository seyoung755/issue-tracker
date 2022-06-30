package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.issue.presentation.dto.FilteringCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.codesquad.issuetracker.comment.domain.QComment.comment;
import static com.codesquad.issuetracker.issue.domain.QIssue.issue;
import static com.codesquad.issuetracker.issue.domain.QIssueAssignee.issueAssignee;
import static com.codesquad.issuetracker.issue.domain.QIssueLabel.issueLabel;
import static com.codesquad.issuetracker.label.domain.QLabel.label;
import static com.codesquad.issuetracker.milestone.domain.QMilestone.milestone;
import static com.codesquad.issuetracker.user.domain.QUser.user;

@Slf4j
@RequiredArgsConstructor
public class IssueRepositoryImpl implements IssueCustomRepository {

    private static final String FILTER_KEYWORD = "@me";

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Issue> findAllByFilteringCondition(Long userId, FilteringCondition filteringCondition) {

        return queryFactory.selectFrom(issue)
                .join(issue.user).fetchJoin()
                .leftJoin(issue.milestone, milestone).fetchJoin()
                .leftJoin(issue.labels, issueLabel).fetchJoin()
                .leftJoin(issueLabel.label, label).fetchJoin()
                .leftJoin(issue.comments, comment)
                .leftJoin(issue.assignees, issueAssignee)
                .leftJoin(issueAssignee.assignee, user)
                .where(author(filteringCondition.getAuthorId()),
                        milestone(filteringCondition.getMilestoneName()),
                        label(filteringCondition.getLabelName()),
                        comment(userId, filteringCondition.getCommentAuthor()),
                        assignee(filteringCondition.getAssigneeId()),
                        isNotDeleted())
                .distinct()
                .fetch();
    }

    @Override
    public Long countByFilteringCondition(Long userId, FilteringCondition filteringCondition) {
        return queryFactory.select(issue.count()).from(issue)
                .where(author(filteringCondition.getAuthorId()),
                        milestone(filteringCondition.getMilestoneName()),
                        label(filteringCondition.getLabelName()),
                        comment(userId, filteringCondition.getCommentAuthor()),
                        assignee(filteringCondition.getAssigneeId()),
                        isNotDeleted())
                .fetchOne();
    }

    @Override
    public Optional<Issue> findIssueDetailById(long issueId) {
        return Optional.ofNullable(queryFactory
                .selectFrom(issue)
                .distinct()
                .leftJoin(issue.labels, issueLabel)
                .leftJoin(issueLabel.label, label)
                .leftJoin(issue.assignees, issueAssignee)
                .leftJoin(issueAssignee.assignee, user)
                .leftJoin(issue.milestone, milestone).fetchJoin()
                .leftJoin(milestone.issues).fetchJoin()
                .where(issue.id.eq(issueId))
                .fetchOne());
    }

    private BooleanExpression isNotDeleted() {
        return issue.isDeleted.eq(false);
    }

    private BooleanExpression assignee(Long assigneeId) {
        if (assigneeId != null) {
            return user.id.eq(assigneeId);
        }
        return null;
    }

    private BooleanExpression comment(Long userId, String authorName) {
        if (StringUtils.hasText(authorName) && authorName.equals(FILTER_KEYWORD)) {
            return comment.user.id.eq(userId);
        }
        return null;
    }

    private BooleanExpression label(String labelName) {
        if (StringUtils.hasText(labelName)) {
            return label.labelName.eq(labelName);
        }
        return null;
    }

    private BooleanExpression milestone(String milestoneName) {
        if (StringUtils.hasText(milestoneName)) {
            return milestone.name.eq(milestoneName);
        }
        return null;
    }

    private BooleanExpression author(Long authorId) {
        if (authorId != null) {
            return issue.user.id.eq(authorId);
        }
        return null;
    }

    private BooleanExpression status(IssueStatus issueStatus) {
        if (issueStatus != null) {
            return issue.issueStatus.eq(issueStatus);
        }
        return issue.issueStatus.eq(IssueStatus.OPEN);
    }
}
