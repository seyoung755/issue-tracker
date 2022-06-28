package com.codesquad.issuetracker.milestone.application;

import com.codesquad.issuetracker.milestone.domain.MilestoneRepository;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneCountDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneResponseDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestoneSaveRequestDto;
import com.codesquad.issuetracker.milestone.presentation.dto.MilestonesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    @Transactional
    public long save(MilestoneSaveRequestDto milestoneSaveRequestDto) {

        return milestoneRepository.save(milestoneSaveRequestDto.toEntity()).getId();
    }

    public MilestoneCountDto count() {
        return new MilestoneCountDto(milestoneRepository.count());
    }

    public MilestonesResponseDto findAll() {

        return new MilestonesResponseDto(milestoneRepository.findAll()
                .stream()
                .map(milestone ->
                        new MilestoneResponseDto(
                                milestone.getName(),
                                milestone.getDueDate(),
                                milestone.getDescription(),
                                milestone.getInformation())
                ).collect(Collectors.toList()));
    }
}
