package com.baeldung.ls.persistence.repository.impl;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@PropertySource("classpath:application.properties")
@Profile("prod")
public class ProjectRepositoryDbBasedImpl implements IProjectRepository {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProjectRepositoryDbBasedImpl.class);

    private final String prefix;

    private final Integer suffix;

    private final List<Project> projects = new ArrayList<>();

    public ProjectRepositoryDbBasedImpl(
            @Value("${project.prefix:PRO}") String prefix, @Value("${project.suffix}") Integer suffix) {
        super();
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }

    @PostConstruct
    public void init() {
        LOGGER.info("Project prefix: {}, suffix: {}", prefix, suffix);
    }
}
