package com.baeldung.ls.web.controller;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.web.dto.ProjectDto;
import com.baeldung.ls.web.dto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    // No need for @ResponseBody, because @RestController already includes it
    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project project = projectService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));
        return convertProjectToDto(project);
    }

    // Only resolved if the client accepts JSON as response
    @PostMapping(headers = "accept=application/json")
    @ResponseStatus(HttpStatus.CREATED) // Overrides 200 with 201. Can also be used on Exception classes
    public void create(@RequestBody ProjectDto project) {
        projectService.save(convertProjectToEntity(project));
    }

    @GetMapping
    public List<ProjectDto> findProjects(@RequestParam(value = "name", required = true) String name) {
        return projectService.findByName(name).stream()
                .map(this::convertProjectToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteById(id);
    }

    private ProjectDto convertProjectToDto(Project entity) {
        return new ProjectDto(
                entity.getId(),
                entity.getName(),
                entity.getDateCreated(),
                entity.getTasks().stream().map(this::convertTaskToDto).collect(Collectors.toSet()));
    }

    private Project convertProjectToEntity(ProjectDto dto) {
        Project project = new Project(dto.name(), dto.dateCreated());
        if (dto.id() != null) {
            project.setId(dto.id());
        }
        project.setTasks(dto.tasks().stream().map(this::convertTaskToEntity).collect(Collectors.toSet()));
        return project;
    }

    private TaskDto convertTaskToDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDateCreated(),
                task.getDueDate(),
                task.getStatus());
    }

    private Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.name(), dto.description(), dto.dateCreated(), dto.dueDate());
        if (dto.id() != null) {
            task.setId(dto.id());
        }
        task.setStatus(dto.status());
        return task;
    }
}
