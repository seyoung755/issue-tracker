package com.codesquad.issuetracker.issue.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.IssueExceptionType;
import com.codesquad.issuetracker.exception.domain.type.MilestoneExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.issue.application.dto.IssueAssigneeEditDto;
import com.codesquad.issuetracker.issue.application.dto.IssueDto;
import com.codesquad.issuetracker.issue.application.dto.IssueLabelEditDto;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.issue.domain.IssueAssignee;
import com.codesquad.issuetracker.issue.domain.IssueLabel;
import com.codesquad.issuetracker.issue.domain.IssueRepository;
import com.codesquad.issuetracker.label.domain.Label;
import com.codesquad.issuetracker.label.domain.LabelRepository;
import com.codesquad.issuetracker.milestone.domain.Milestone;
import com.codesquad.issuetracker.milestone.domain.MilestoneRepository;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class IssueService {

    private final UserRepository userRepository;
    private final IssueRepository issueRepository;
    private final LabelRepository labelRepository;
    private final MilestoneRepository milestoneRepository;

    @Transactional
    public long save(IssueDto issueDto) {
        User user = findUser(issueDto.getUserId());
        Issue issue = new Issue(issueDto.getTitle(), issueDto.getContent(), user);

        if (issueDto.getMilestoneName() != null) {
            issue.updateMilestone(findMilestone(issueDto.getMilestoneName()));
        }

        issueRepository.save(issue);

        if (issueDto.getAssignees() != null) {
            List<IssueAssignee> issueAssignees = createIssueAssignees(issueDto.getAssignees(), issue);
            issue.updateAssignees(issueAssignees);
        }

        if (issueDto.getLabelNames() != null) {
            List<IssueLabel> labels = createIssueLabels(issueDto.getLabelNames(), issue);
            issue.updateLabels(labels);
        }

        return issue.getId();
    }

    @Transactional
    public void editAssignee(IssueAssigneeEditDto issueAssigneeEditDto) {
        Issue issue = findIssue(issueAssigneeEditDto.getIssueId());

        List<IssueAssignee> assignees = createIssueAssignees(issueAssigneeEditDto.getAssignees(), issue);

        issue.updateAssignees(assignees);
    }

    @Transactional
    public void editLabels(IssueLabelEditDto issueLabelEditDto) {
        Issue issue = findIssue(issueLabelEditDto.getIssueId());

        List<IssueLabel> labels = createIssueLabels(issueLabelEditDto.getLabelNames(), issue);

        issue.updateLabels(labels);
    }

    private List<IssueAssignee> createIssueAssignees(List<Long> assigneeIds, Issue issue) {
        List<User> assignees = userRepository.findAllById(assigneeIds);
        validateInputMatchWithResult(assigneeIds.size(), assignees.size());
        return assignees.stream()
                .map(user -> new IssueAssignee(issue, user))
                .collect(Collectors.toList());
    }

    private List<IssueLabel> createIssueLabels(List<String> labelNames, Issue issue) {
        List<Label> labels = labelRepository.findAllByLabelNameIn(labelNames);
        validateInputMatchWithResult(labelNames.size(), labels.size());
        return labels.stream()
                .map(label -> new IssueLabel(issue, label))
                .collect(Collectors.toList());
    }

    private void validateInputMatchWithResult(int inputSize, int resultSize) {
        if (inputSize != resultSize) {
            throw new BusinessException(UserExceptionType.NOT_FOUND);
        }
    }

    private Milestone findMilestone(String milestoneName) {
        return milestoneRepository
                .findByName(milestoneName)
                .orElseThrow(() -> new BusinessException(MilestoneExceptionType.NOT_FOUND));
    }

    private User findUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(UserExceptionType.NOT_FOUND));
    }

    private Issue findIssue(long issueId) {
        return issueRepository.findById(issueId)
                .orElseThrow(() -> new BusinessException(IssueExceptionType.NOT_FOUND));
    }
}
