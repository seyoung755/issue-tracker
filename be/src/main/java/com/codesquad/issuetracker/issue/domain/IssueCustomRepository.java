package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.issue.presentation.dto.FilteringCondition;

import java.util.List;
import java.util.Optional;

public interface IssueCustomRepository {

    List<Issue> findAllByFilteringCondition(Long userId, FilteringCondition filteringCondition);

    Long countByFilteringCondition(Long userId, FilteringCondition filteringCondition);

    Optional<Issue> findIssueDetailById(long issueId);
}
