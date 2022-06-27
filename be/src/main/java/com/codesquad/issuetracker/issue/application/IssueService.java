package com.codesquad.issuetracker.issue.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.MilestoneExceptionType;
import com.codesquad.issuetracker.exception.domain.type.UserExceptionType;
import com.codesquad.issuetracker.issue.application.dto.IssueDto;
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
            List<IssueAssignee> issueAssignees = findAssignees(issueDto.getAssignees(), issue);
            issue.addAssignees(issueAssignees);
        }

        if (issueDto.getLabelNames() != null) {
            List<IssueLabel> labels = findLabels(issueDto.getLabelNames(), issue);
            issue.addLabels(labels);
        }

        return issue.getId();
    }

    private List<IssueAssignee> findAssignees(List<Long> assigneeIds, Issue issue) {
        List<User> assignees = userRepository.findAllById(assigneeIds);
        return assignees.stream()
                .map(user -> new IssueAssignee(issue, user))
                .collect(Collectors.toList());
    }

    private List<IssueLabel> findLabels(List<String> labelNames, Issue issue) {
        List<Label> labels = labelRepository.findAllByName(labelNames);
        return labels.stream()
                .map(label -> new IssueLabel(issue, label))
                .collect(Collectors.toList());
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

}
