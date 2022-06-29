package com.codesquad.issuetracker.label.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {

    List<Label> findAllByLabelNameIn(List<String> labelNames);

    List<Label> findAllByIsDeleted(boolean b);

    int countByIsDeleted(boolean b);

    Optional<Label> findByIdAndIsDeleted(long labelId, boolean b);
}
