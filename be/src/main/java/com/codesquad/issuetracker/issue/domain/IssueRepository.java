package com.codesquad.issuetracker.issue.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Optional<Issue> findByIdAndIsDeleted(long issueId, boolean b);
}
