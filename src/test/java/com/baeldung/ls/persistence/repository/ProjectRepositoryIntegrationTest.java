package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@ActiveProfiles("dev")
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());

        assertThat(projectRepository.save(newProject), is(CoreMatchers.notNullValue()));
    }

    @Test
    public void givenProjectCreated_whenFindById_thenSuccess() {
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());

        assertThat(retrievedProject, is(equalTo(Optional.of(newProject))));
    }

    @Test
    public void givenProjectCreated_whenFindByName_thenSuccess() {
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());

        assertThat(retrievedProject, is(equalTo(Optional.of(newProject))));
    }

    @Test
    public void givenProjectCreated_whenFindByDateCreatedBetween_thenSuccess() {
        var oldProject =
                new Project(RandomStringUtils.secure().next(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());
        projectRepository.save(newProject);
        var newProject2 = new Project(RandomStringUtils.secure().next(6), LocalDate.now());
        projectRepository.save(newProject2);

        var retrievedProjects =
                projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now());

        assertThat(retrievedProjects, hasItems(newProject, newProject2));
    }

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProjects = projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        Assertions.assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects =
                projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }
}
