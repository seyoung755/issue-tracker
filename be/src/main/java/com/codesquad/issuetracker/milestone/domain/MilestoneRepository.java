package com.codesquad.issuetracker.milestone.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    Optional<Milestone> findByNameAndIsDeleted(String milestoneName, boolean b);

    @Query("select distinct m from Milestone m join fetch m.issues where m.isDeleted=false")
    List<Milestone> findAll();

    Optional<Milestone> findByIdAndIsDeleted(long milestoneId, boolean b);
}
