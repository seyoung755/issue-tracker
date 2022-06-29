package com.codesquad.issuetracker.comment.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;

    public Comment(String content, User user, Issue issue) {
        this.content = content;
        this.user = user;
        this.issue = issue;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        changeDeleted(false);
    }
}
