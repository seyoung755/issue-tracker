package com.codesquad.issuetracker.milestone.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    Optional<Milestone> findByName(String milestoneName);
}
