package com.codesquad.issuetracker.issue.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.IssueExceptionType;
import com.codesquad.issuetracker.exception.domain.type.MilestoneExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.issue.domain.*;
import com.codesquad.issuetracker.issue.presentation.dto.*;
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

    public IssuesResponseDto findAll(Long userId, FilteringCondition filteringCondition) {

        List<Issue> totalIssues = issueRepository.findAllByFilteringCondition(userId, filteringCondition);

        int totalCount = totalIssues.size();

        long openCount = totalIssues.stream().filter(Issue::isOpen).count();

        List<Issue> filteredIssues = totalIssues.stream()
                .filter(issue -> issue.doesMatchStatus(filteringCondition.getIssueStatus()))
                .collect(Collectors.toList());

        return IssuesResponseDto.of(filteredIssues, openCount, totalCount - openCount);
    }

    @Transactional
    public long save(long userId, IssueSaveRequestDto issueSaveRequestDto) {
        User user = findUser(userId);
        Issue issue = new Issue(issueSaveRequestDto.getTitle(), issueSaveRequestDto.getContent(), user);

        if (issueSaveRequestDto.getMilestoneName() != null) {
            issue.updateMilestone(findMilestone(issueSaveRequestDto.getMilestoneName()));
        }

        issueRepository.save(issue);

        if (issueSaveRequestDto.getAssignees() != null) {
            List<IssueAssignee> issueAssignees = createIssueAssignees(issueSaveRequestDto.getAssignees(), issue);
            issue.updateAssignees(issueAssignees);
        }

        if (issueSaveRequestDto.getLabelNames() != null) {
            List<IssueLabel> labels = createIssueLabels(issueSaveRequestDto.getLabelNames(), issue);
            issue.updateLabels(labels);
        }

        return issue.getId();
    }

    @Transactional
    public void editAssignee(long issueId, IssueAssigneeEditRequestDto issueAssigneeEditRequestDto) {
        Issue issue = findIssue(issueId);

        List<IssueAssignee> assignees = createIssueAssignees(issueAssigneeEditRequestDto.getAssignees(), issue);

        issue.updateAssignees(assignees);
    }

    @Transactional
    public void editLabels(long issueId, IssueLabelEditRequestDto issueLabelEditRequestDto) {
        Issue issue = findIssue(issueId);

        List<IssueLabel> labels = createIssueLabels(issueLabelEditRequestDto.getLabelNames(), issue);

        issue.updateLabels(labels);
    }

    @Transactional
    public void editMilestone(long issueId, IssueMilestoneEditRequestDto issueMilestoneEditRequestDto) {
        Issue issue = findIssue(issueId);

        Milestone milestone = findMilestone(issueMilestoneEditRequestDto.getMilestoneName());

        issue.updateMilestone(milestone);
    }

    @Transactional
    public void editContent(long issueId, IssueContentEditRequestDto issueContentEditRequestDto) {
        Issue issue = findIssue(issueId);

        issue.updateContent(issueContentEditRequestDto.getContent());
    }

    @Transactional
    public void editTitle(long issueId, IssueTitleEditRequestDto issueTitleEditRequestDto) {
        Issue issue = findIssue(issueId);

        issue.updateTitle(issueTitleEditRequestDto.getTitle());
    }

    @Transactional
    public long softDelete(long issueId) {
        Issue issue = findIssue(issueId);

        issue.delete();
        return issueId;
    }

    @Transactional
    public void changeStatus(IssueStatusDto issueStatusDto) {
        IssueStatus changedStatus = issueStatusDto.getStatus();

        issueStatusDto.getIssues()
                .forEach(id -> findIssue(id).changeStatus(changedStatus));

    }

    public IssueDetailDto findOne(long issueId) {
        Issue issue = findIssueDetail(issueId);

        return IssueDetailDto.from(issue);
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
        return milestoneRepository.findByNameAndIsDeleted(milestoneName, false)
                .orElseThrow(() -> new BusinessException(MilestoneExceptionType.NOT_FOUND));
    }

    private User findUser(long userId) {
        return userRepository.findByIdAndIsDeleted(userId, false)
                .orElseThrow(() -> new BusinessException(UserExceptionType.NOT_FOUND));
    }

    private Issue findIssue(long issueId) {
        return issueRepository.findByIdAndIsDeleted(issueId, false)
                .orElseThrow(() -> new BusinessException(IssueExceptionType.NOT_FOUND));
    }

    private Issue findIssueDetail(long issueId) {
        return issueRepository.findIssueDetailById(issueId)
                .orElseThrow(() -> new BusinessException(IssueExceptionType.NOT_FOUND));
    }
}
