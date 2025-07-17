package com.baeldung.ls.service;

import com.baeldung.ls.persistence.model.ProjectInMemory;

import java.util.Optional;

public interface IProjectServiceInMemory {

    Optional<ProjectInMemory> findById(Long id);

    ProjectInMemory save(ProjectInMemory projectInMemory);
}
