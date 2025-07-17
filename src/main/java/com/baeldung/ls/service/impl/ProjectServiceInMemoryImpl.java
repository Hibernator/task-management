package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.IProjectServiceInMemory;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class ProjectServiceInMemoryImpl implements IProjectServiceInMemory, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceInMemoryImpl.class);

    private IProjectRepositoryInMemory projectRepository;

    public ProjectServiceInMemoryImpl(
            @Qualifier("projectRepositoryInMemoryImpl") IProjectRepositoryInMemory projectRepositoryInMemory,
            @Qualifier("projectRepositoryInMemoryImpl2") IProjectRepositoryInMemory projectRepositoryInMemory2) {
        this.projectRepository = projectRepositoryInMemory;
    }

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        LOG.debug("ProjectInMemory Service >> Finding ProjectInMemory by Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        LOG.debug("ProjectInMemory Service >> Saving ProjectInMemory {}", projectInMemory);
        return projectRepository.save(projectInMemory);
    }

    @PostConstruct
    public void init() {
        System.out.println("ProjectServiceInMemoryImpl init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.info("Application context with id '{}' set", applicationContext.getId());
    }
}
