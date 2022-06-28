package com.codesquad.issuetracker.issue.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum IssueStatus {

    OPEN, CLOSED;

    @JsonCreator
    public static IssueStatus from(String name) {
        return IssueStatus.valueOf(name.toUpperCase());
    }
}
