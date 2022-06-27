package com.codesquad.issuetracker.milestone.domain;

import com.codesquad.issuetracker.common.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Milestone extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private LocalDate dueDate;
    private String description;
}
