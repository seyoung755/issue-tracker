package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.comment.domain.Comment;
import com.codesquad.issuetracker.milestone.domain.Milestone;
import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Milestone milestone;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private Set<IssueAssignee> assignees = new HashSet<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private Set<IssueLabel> labels = new HashSet<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Issue(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void updateMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public void addAssignees(List<IssueAssignee> issueAssignees) {
        this.assignees.addAll(issueAssignees);
    }

    public void addLabels(List<IssueLabel> labels) {
        this.labels.addAll(labels);
    }
}
