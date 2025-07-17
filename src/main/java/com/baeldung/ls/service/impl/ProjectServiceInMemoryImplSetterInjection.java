package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.IProjectServiceInMemory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Lazy
@Service
public class ProjectServiceInMemoryImplSetterInjection implements IProjectServiceInMemory {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceInMemoryImplSetterInjection.class);

    private IProjectRepositoryInMemory projectRepositoryInMemory;
    private ApplicationContext applicationContext;

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return projectRepositoryInMemory.findById(id);
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        return projectRepositoryInMemory.save(projectInMemory);
    }

    @Autowired
    @Qualifier("projectRepositoryInMemoryImpl")
    public void setProjectRepositoryInMemory(IProjectRepositoryInMemory projectRepositoryInMemory) {
        this.projectRepositoryInMemory = projectRepositoryInMemory;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        LOG.info("Creating ProjectInMemory Service in the Application Context '{}'", this.applicationContext.getId());
    }
}