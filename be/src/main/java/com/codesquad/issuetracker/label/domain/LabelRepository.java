package com.codesquad.issuetracker.label.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long> {


    List<Label> findAllByName(Iterable<String> names);
}
