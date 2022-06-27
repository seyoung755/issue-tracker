package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class IssueAssignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;

    public IssueAssignee(Issue issue, User user) {
        this.issue = issue;
        this.assignee = user;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IssueAssignee)) {
            return false;
        }
        IssueAssignee issueAssignee = (IssueAssignee) o;
        return Objects.equals(issueAssignee.getAssignee(), assignee) &&
                Objects.equals(issueAssignee.getIssue(), issue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignee, issue);
    }
}
