package com.codesquad.issuetracker.integrationtest;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.IssueExceptionType;
import com.codesquad.issuetracker.issue.application.IssueService;
import com.codesquad.issuetracker.issue.domain.Issue;
import com.codesquad.issuetracker.issue.domain.IssueRepository;
import com.codesquad.issuetracker.issue.presentation.dto.*;
import com.codesquad.issuetracker.label.domain.Label;
import com.codesquad.issuetracker.label.domain.LabelRepository;
import com.codesquad.issuetracker.label.domain.TextColor;
import com.codesquad.issuetracker.milestone.domain.Milestone;
import com.codesquad.issuetracker.milestone.domain.MilestoneRepository;
import com.codesquad.issuetracker.user.domain.LoginType;
import com.codesquad.issuetracker.user.domain.User;
import com.codesquad.issuetracker.user.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
class IssueTest {

    private static final Logger log = LoggerFactory.getLogger(IssueTest.class);

    @Autowired
    IssueService issueService;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MilestoneRepository milestoneRepository;

    @Autowired
    LabelRepository labelRepository;

    User testUser;


    @BeforeEach
    void setUp() {
        testUser = new User("유저이름", "이름", "1234asdf!", "link", LoginType.NORMAL);

        userRepository.save(testUser);

        Issue testIssue = new Issue("테스트 제목", "테스트 내용", testUser);

        issueRepository.save(testIssue);


    }

    @Test
    void 이슈를_작성하고_조회하면_개수가_늘어난다() {
        int size = issueRepository.findAll().size();

        Issue issue = new Issue("테스트 제목", "테스트 내용", testUser);

        IssueSaveRequestDto issueSaveRequestDto = getIssueSaveRequestDto();

        Long findId = issueService.save(testUser.getId(), issueSaveRequestDto);

        assertThat(issueRepository.findAll().size()).isEqualTo(size + 1);
    }

    @Test
    void 이슈의_정보가_수정된다() {

        long savedIssueId = issueService.save(testUser.getId(), getIssueSaveRequestDto());
        Milestone milestone = saveAndGetMilestone("마일스톤 이름");
        Label label = saveAndGetLabel("라벨 이름");

        issueService.editContent(savedIssueId, new IssueContentEditRequestDto("수정 내용"));
        issueService.editTitle(savedIssueId, new IssueTitleEditRequestDto("수정 제목"));
        issueService.editMilestone(savedIssueId, new IssueMilestoneEditRequestDto(milestone.getName()));
        issueService.editLabels(savedIssueId, new IssueLabelEditRequestDto(List.of("라벨 이름")));
        issueService.editAssignee(savedIssueId, new IssueAssigneeEditRequestDto(List.of(testUser.getId())));

        assertThat(findIssue(savedIssueId).getContent()).isEqualTo("수정 내용");
        assertThat(findIssue(savedIssueId).getTitle()).isEqualTo("수정 제목");
        assertThat(findIssue(savedIssueId).getMilestone().getId()).isEqualTo(milestone.getId());
        assertThat(findIssue(savedIssueId).getLabels()).hasSize(1);
        assertThat(findIssue(savedIssueId).getLabels().get(0).getLabel().getLabelName()).isEqualTo("라벨 이름");
        assertThat(findIssue(savedIssueId).getAssignees().get(0).getAssignee().getId()).isEqualTo(testUser.getId());
    }

    @Test
    void 이슈를_등록할때_담당자나_라벨이나_마일스톤이_추가된다() {
        Label label1 = saveAndGetLabel("라벨 이름1");
        Label label2 = saveAndGetLabel("라벨 이름2");
        Milestone milestone = saveAndGetMilestone("마일스톤 이름");

        IssueSaveRequestDto issueSaveRequestDto = new IssueSaveRequestDto("테스트 제목",
                "테스트 내용",
                List.of(testUser.getId()),
                List.of("라벨 이름1", "라벨 이름2"),
                "마일스톤 이름");

        long savedIssueId = issueService.save(testUser.getId(), issueSaveRequestDto);

        assertThat(findIssue(savedIssueId).getMilestone().getName()).isEqualTo(milestone.getName());
        assertThat(findIssue(savedIssueId).getLabels().size()).isEqualTo(2);
        assertThat(findIssue(savedIssueId).getAssignees().size()).isEqualTo(1);
    }

    @Test
    void 이슈_상세정보가_조회된다() {
        Label label1 = saveAndGetLabel("라벨 이름1");
        Label label2 = saveAndGetLabel("라벨 이름2");
        Milestone milestone = saveAndGetMilestone("마일스톤 이름");

        IssueSaveRequestDto issueSaveRequestDto = new IssueSaveRequestDto("테스트 제목",
                "테스트 내용",
                List.of(testUser.getId()),
                List.of("라벨 이름1", "라벨 이름2"),
                "마일스톤 이름");

        long savedIssueId = issueService.save(testUser.getId(), issueSaveRequestDto);

        log.info("findOne start");

        IssueDetailDto issueDetailDto = issueService.findOne(savedIssueId);

        assertThat(issueDetailDto.getAuthor().getName()).isEqualTo(testUser.getName());
    }

    private Issue findIssue(long issueId) {
        return issueRepository.findById(issueId)
                .orElseThrow(() -> new BusinessException(IssueExceptionType.NOT_FOUND));
    }

    private IssueSaveRequestDto getIssueSaveRequestDto() {
        return new IssueSaveRequestDto("테스트 제목",
                        "테스트 내용",
                        List.of(testUser.getId()),
                        null,
                        null);
    }

    private Milestone saveAndGetMilestone(String milestoneName) {
        Milestone milestone = new Milestone(milestoneName, LocalDate.now(), "백기선 토비");

        return milestoneRepository.save(milestone);
    }

    private Label saveAndGetLabel(String labelName) {
        Label label = new Label(labelName, "라벨 설명", "라벨 색상", TextColor.LIGHT);

        return labelRepository.save(label);
    }
}
