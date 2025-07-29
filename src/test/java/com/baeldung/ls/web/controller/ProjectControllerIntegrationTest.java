package com.baeldung.ls.web.controller;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.ITaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Now the Tomcat port will be taken from the application.properties file
// This loads the entire application context, including the web layer
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

// Now, only the web layer is loaded, which is faster and more focused for controller tests
// This is useful for testing controllers without starting the entire application context
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
// Since only the web layer is loaded, we need to mock the services required by the controller
@MockitoBean(types = {ITaskService.class})
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProjectService projectService;

    @Test
    public void whenWebEnvIsInstantiated_thenOK() {
        // This test is just to ensure that the web environment is set up correctly.
        // No actual assertions are needed here, as the context loading will fail if there are issues.
    }

    @Test
    public void whenProjectExists_thenGetSuccess() throws Exception {

        Mockito.when(projectService.findById(1L)).thenReturn(Optional.of(new Project("testName", null)));

        mockMvc.perform(MockMvcRequestBuilders.get("/projects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testName"));
    }
}
