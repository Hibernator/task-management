package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());

        MatcherAssert.assertThat(projectRepository.save(newProject), CoreMatchers.is(CoreMatchers.notNullValue()));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        var newProject = new Project(RandomStringUtils.secure().next(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());

        MatcherAssert.assertThat(retrievedProject, CoreMatchers.is(CoreMatchers.equalTo(Optional.of(newProject))));
    }
}
