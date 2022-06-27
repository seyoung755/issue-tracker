package com.codesquad.issuetracker.label.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String labelName;
    private String description;
    private String colorCode;

    @Enumerated(EnumType.STRING)
    private TextColor textColor;
}
