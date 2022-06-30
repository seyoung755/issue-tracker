package com.codesquad.issuetracker.label.application;

import com.codesquad.issuetracker.exception.domain.BusinessException;
import com.codesquad.issuetracker.exception.domain.type.LabelExceptionType;
import com.codesquad.issuetracker.label.domain.Label;
import com.codesquad.issuetracker.label.domain.LabelRepository;
import com.codesquad.issuetracker.label.presentation.dto.LabelCountDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelResponseDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelSaveRequestDto;
import com.codesquad.issuetracker.label.presentation.dto.LabelsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LabelService {

    private final LabelRepository labelRepository;

    public LabelsResponseDto findAll() {
        return new LabelsResponseDto(labelRepository.findAllByIsDeleted(false)
                .stream()
                .map(LabelResponseDto::from)
                .collect(Collectors.toList()));
    }

    public LabelCountDto count() {
        return new LabelCountDto(labelRepository.countByIsDeleted(false));
    }

    @Transactional
    public long save(LabelSaveRequestDto labelSaveRequestDto) {
        return labelRepository.save(labelSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public LabelResponseDto edit(long labelId, LabelSaveRequestDto labelSaveRequestDto) {
        Label label = findLabel(labelId);

        label.editInformation(labelSaveRequestDto.toEntity());

        return LabelResponseDto.from(label);
    }

    @Transactional
    public long softDelete(long labelId) {
        Label label = findLabel(labelId);

        label.delete();

        return label.getId();
    }

    private Label findLabel(long labelId) {
        return labelRepository.findByIdAndIsDeleted(labelId, false)
                .orElseThrow(() -> new BusinessException(LabelExceptionType.NOT_FOUND));
    }
}

