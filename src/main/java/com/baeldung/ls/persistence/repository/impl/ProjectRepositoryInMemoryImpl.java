package com.baeldung.ls.persistence.repository.impl;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@PropertySource("classpath:application.properties")
@Profile("dev")
@Primary
public class ProjectRepositoryInMemoryImpl implements IProjectRepositoryInMemory {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProjectRepositoryInMemoryImpl.class);

    private final String prefix;

    private final Integer suffix;

    private final List<ProjectInMemory> projectInMemories = new ArrayList<>();

    public ProjectRepositoryInMemoryImpl(
            @Value("${project.prefix:PRO}") String prefix, @Value("${project.suffix}") Integer suffix) {
        super();
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Optional<ProjectInMemory> findById(Long id) {
        return projectInMemories.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public ProjectInMemory save(ProjectInMemory projectInMemory) {
        ProjectInMemory existingProjectInMemory =
                findById(projectInMemory.getId()).orElse(null);
        updateInternalId(projectInMemory);
        if (existingProjectInMemory == null) {
            projectInMemories.add(projectInMemory);
        } else {
            projectInMemories.remove(existingProjectInMemory);
            ProjectInMemory newProjectInMemory = new ProjectInMemory(projectInMemory);
            projectInMemories.add(newProjectInMemory);
        }
        return projectInMemory;
    }

    private void updateInternalId(ProjectInMemory projectInMemory) {
        projectInMemory.setInternalId(prefix + "-" + projectInMemory.getId() + "-" + suffix);
    }

    @PostConstruct
    public void init() {
        LOGGER.info("ProjectInMemory prefix: {}, suffix: {}", prefix, suffix);
    }
}
