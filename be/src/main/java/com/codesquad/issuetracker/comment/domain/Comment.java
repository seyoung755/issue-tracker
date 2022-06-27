package com.codesquad.issuetracker.comment.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.user.domain.User;

import javax.persistence.*;

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
}
