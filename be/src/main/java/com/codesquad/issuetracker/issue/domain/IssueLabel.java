package com.codesquad.issuetracker.issue.domain;

import com.codesquad.issuetracker.label.domain.Label;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class IssueLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;
    @ManyToOne(fetch = FetchType.LAZY)
    private Label label;


    public IssueLabel(Issue issue, Label label) {
        this.issue = issue;
        this.label = label;
    }
}
