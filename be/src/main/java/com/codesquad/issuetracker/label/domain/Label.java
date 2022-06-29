package com.codesquad.issuetracker.label.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import com.codesquad.issuetracker.label.presentation.dto.LabelSaveRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Label extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String labelName;
    private String description;

    @Column(nullable = false)
    private String colorCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TextColor textColor;

    public Label(String labelName, String description, String colorCode, TextColor textColor) {
        this.labelName = labelName;
        this.description = description;
        this.colorCode = colorCode;
        this.textColor = textColor;
    }

    public void editInformation(LabelSaveRequestDto labelSaveRequestDto) {
        labelName = labelSaveRequestDto.getLabelName();
        description = labelSaveRequestDto.getDescription();
        colorCode = labelSaveRequestDto.getColorCode();
        textColor = labelSaveRequestDto.getTextColor();
    }

    public void delete() {
    super.changeDeleted(true);
    }
}
