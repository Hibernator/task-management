package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.IProjectServiceInMemory;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceInMemoryInjectImpl implements IProjectServiceInMemory {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceInMemoryResourceImpl.class);

    private IProjectRepositoryInMemory projectRepositoryInMemory;

    // Can also be used on field and method
    @Inject
    @Named("projectRepositoryInMemoryImpl")
    public ProjectServiceInMemoryInjectImpl(IProjectRepositoryInMemory projectRepositoryInMemory) {
        this.projectRepositoryInMemory = projectRepositoryInMemory;
        LOG.info("Wired projectRepositoryInMemory instance {}", projectRepositoryInMemory);
    }

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        return null;
    }
}
