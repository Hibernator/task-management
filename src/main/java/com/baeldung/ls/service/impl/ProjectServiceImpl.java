package com.baeldung.ls.service.impl;

import com.baeldung.ls.exception.TaskNotSavedException;
import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.ITaskService;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;
    private ITaskService taskService;

    public ProjectServiceImpl(IProjectRepository projectRepository, ITaskService taskService) {
        this.projectRepository = projectRepository;
        this.taskService = taskService;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("ProjectService >> Finding Project by Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    //    @PreAuthorize("hasRole('MANAGER')") // authorization directly on method, with SpEL expression
    //    @Secured("MANAGER") // alternative way to secure method, doesn't support SpEL
    //    @RolesAllowed("MANAGER") // JSR-250 equivalent of @Secured annotation, requires
    //    @PostAuthorize("hasRole('MANAGER')") // SpEL expression to evaluate after method execution, can change the
    // result
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findByName(String name) {
        return projectRepository.findByNameContaining(name);
    }

    @Override
    @Transactional
    public Project save(Project project) {
        LOG.debug("ProjectService >> Saving Project {}", project);
        return projectRepository.save(project);
    }

    @Transactional(rollbackFor = TaskNotSavedException.class)
    @Override
    public void createProjectWithTasks() throws TaskNotSavedException {
        Project project = new Project("Project 1", LocalDate.now());

        Project newProject = save(project);

        Task task1 = new Task(
                "Task 1", "Project 1 Task 1", LocalDate.now(), LocalDate.now().plusDays(7));

        taskService.save(task1);

        Set<Task> tasks = new HashSet<>();
        tasks.add(task1);

        newProject.setTasks(tasks);

        save(newProject);
    }

    @Override
    public void deleteById(Long id) {
        findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException("Project with id " + id + " does not exist", 1));
        projectRepository.deleteById(id);
    }
}
