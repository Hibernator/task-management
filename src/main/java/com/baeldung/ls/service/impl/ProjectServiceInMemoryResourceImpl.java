package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.IProjectServiceInMemory;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceInMemoryResourceImpl implements IProjectServiceInMemory {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceInMemoryResourceImpl.class);

    private IProjectRepositoryInMemory projectRepositoryInMemory;

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return projectRepositoryInMemory.findById(id);
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        return projectRepositoryInMemory.save(projectInMemory);
    }

    @Resource(name = "projectRepositoryInMemoryImpl")
    public void setProjectRepositoryInMemory(IProjectRepositoryInMemory projectRepositoryInMemory) {
        this.projectRepositoryInMemory = projectRepositoryInMemory;
        LOG.info("Wired projectRepository instance {}", projectRepositoryInMemory);
    }
}
