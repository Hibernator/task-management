package com.baeldung.ls.persistence.repository.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryInMemoryImpl2 implements IProjectRepositoryInMemory {

    List<ProjectInMemory> projectInMemories = new ArrayList<>();

    public ProjectRepositoryInMemoryImpl2() {
        super();
    }

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return projectInMemories.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        ProjectInMemory existingProjectInMemory =
                findById(projectInMemory.getId()).orElse(null);
        if (existingProjectInMemory == null) {
            projectInMemories.add(projectInMemory);
        } else {
            projectInMemories.remove(existingProjectInMemory);
            ProjectInMemory newProjectInMemory = new ProjectInMemory(projectInMemory);
            projectInMemories.add(newProjectInMemory);
        }
        return projectInMemory;
    }
}