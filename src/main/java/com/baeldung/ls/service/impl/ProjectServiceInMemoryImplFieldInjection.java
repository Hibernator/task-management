package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.IProjectServiceInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceInMemoryImplFieldInjection implements IProjectServiceInMemory {

    @Autowired
    @Qualifier("projectRepositoryInMemoryImpl")
    private IProjectRepositoryInMemory projectRepositoryInMemory;

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return projectRepositoryInMemory.findById(id);
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        return projectRepositoryInMemory.save(projectInMemory);
    }
}
