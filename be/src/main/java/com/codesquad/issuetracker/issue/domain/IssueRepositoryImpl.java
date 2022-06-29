package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.issue.presentation.dto.FilteringCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.codesquad.issuetracker.comment.domain.QComment.comment;
import static com.codesquad.issuetracker.issue.domain.QIssue.issue;
import static com.codesquad.issuetracker.issue.domain.QIssueLabel.issueLabel;
import static com.codesquad.issuetracker.label.domain.QLabel.label;
import static com.codesquad.issuetracker.milestone.domain.QMilestone.milestone;

@Slf4j
public class IssueRepositoryImpl implements IssueCustomRepository {

    private static final String FILTER_KEYWORD = "@me";

    private final EntityManager em;
    private final JPAQueryFactory query;

    public IssueRepositoryImpl(EntityManager em) {
        this.em = em;
        query = new JPAQueryFactory(em);
    }

    @Override
    public List<Issue> findAllByFilteringCondition(Long userId, FilteringCondition filteringCondition) {

        List<Issue> issues = query.select(issue)
                .from(issue)
                .leftJoin(issue.milestone, milestone)
                .leftJoin(issue.labels, issueLabel)
                .leftJoin(issueLabel.label, label)
                .leftJoin(issue.comments, comment)
                .where(status(filteringCondition.getIssueStatus()),
                        author(filteringCondition.getAuthorId()),
                        milestone(filteringCondition.getMilestoneName()),
                        label(filteringCondition.getLabelName()),
                        comment(userId, filteringCondition.getCommentAuthor()))
                .distinct()
                .fetch();

        for (Issue i : issues) {
            log.debug("issue select : {}", i.getId());
        }

        return issues;
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
