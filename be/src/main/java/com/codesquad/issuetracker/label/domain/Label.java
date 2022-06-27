package com.codesquad.issuetracker.label.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Label {

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
}
