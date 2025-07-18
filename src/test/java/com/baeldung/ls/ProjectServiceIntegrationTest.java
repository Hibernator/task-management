package com.baeldung.ls;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

@SpringJUnitConfig(classes = TestConfig.class)
@ActiveProfiles("dev")
// @DirtiesContext
class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    // Replaces the bean in the context with a mock
    //    @MockitoBean(name = "projectRepositoryImpl")
    //    private IProjectRepositoryInMemory projectRepository;

    @Test
    void whenSavingProject_thenOK() {
        Project savedProjectInMemory = projectService.save(new Project("name", LocalDate.now()));

        MatcherAssert.assertThat(savedProjectInMemory, CoreMatchers.is(CoreMatchers.notNullValue()));
    }
}