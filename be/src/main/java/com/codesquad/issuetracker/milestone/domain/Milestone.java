package com.codesquad.issuetracker.milestone.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.issue.domain.Issue;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Milestone extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private LocalDate dueDate;
    private String description;

    @OneToMany(mappedBy = "milestone")
    private List<Issue> issues = new ArrayList<>();

    public Milestone(String name, LocalDate dueDate, String description) {

        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
    }

    public MilestoneInformation getInformation() {
        long openCount = issues.stream().filter(Issue::isOpen).count();
        long closeCount = issues.size() - openCount;
        double progressRate = Double.parseDouble(String.format("%.3f", ((double) (closeCount) / (openCount + closeCount))));
        return new MilestoneInformation(progressRate, openCount, closeCount);
    }

    public void delete() {
        changeDeleted(true);
    }

    public void editInformation(Milestone milestone) {
        name = milestone.getName();
        dueDate = milestone.getDueDate();
        description = milestone.getDescription();
    }
}
