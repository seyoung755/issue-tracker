package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.comment.domain.Comment;
import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.milestone.domain.Milestone;
import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Getter
@NoArgsConstructor
@Entity
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Milestone milestone;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<IssueAssignee> assignees = new ArrayList<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<IssueLabel> labels = new ArrayList<>();

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

    public void updateAssignees(List<IssueAssignee> assignees) {
        this.assignees.removeIf(assignee -> !assignees.contains(assignee));

        assignees.stream()
                .filter(assignee -> !(this.assignees.contains(assignee)))
                .forEach(assignee -> this.assignees.add(assignee));
    }

    public void updateLabels(List<IssueLabel> labels) {
        this.labels.removeIf(label -> !labels.contains(label));

        labels.stream()
                .filter(label -> !(this.labels.contains(label)))
                .forEach(label -> this.labels.add(label));
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void delete() {
        super.changeDeleted(true);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Issue)) {
            return false;
        }
        Issue issue = (Issue) o;
        return Objects.equals(this.id, issue.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
