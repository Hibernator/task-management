package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    // Spring will automatically implement this method because the method name follows the naming convention
    Optional<Project> findById(Long id);

    Project save(Project project);
}
