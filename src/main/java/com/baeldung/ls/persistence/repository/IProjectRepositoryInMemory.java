package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.ProjectInMemory;

import java.util.Optional;

public interface IProjectRepositoryInMemory {
    Optional<ProjectInMemory> findById(Long id);

    ProjectInMemory save(ProjectInMemory projectInMemory);
}
