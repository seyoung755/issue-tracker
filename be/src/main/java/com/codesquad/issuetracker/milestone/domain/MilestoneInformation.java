package com.codesquad.issuetracker.milestone.domain;

import lombok.Getter;

@Getter
public class MilestoneInformation {

    private double progressRate;
    private long openCount;
    private long closeCount;

    public MilestoneInformation(double progressRate, long openCount, long closeCount) {
        this.progressRate = progressRate;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}
