package com.stacklink.domain.project.repository;

import com.stacklink.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByIsDeletedFalse();

    Optional<Project> findByIdAndIsDeletedFalse(Long id);
}
