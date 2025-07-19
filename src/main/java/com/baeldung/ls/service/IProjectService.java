package com.baeldung.ls.service;

import com.baeldung.ls.exception.TaskNotSavedException;
import com.baeldung.ls.persistence.model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Optional<Project> findByName(String name);

    List<Project> findAll();

    Project save(Project project);

    void createProjectWithTasks() throws TaskNotSavedException;
}
