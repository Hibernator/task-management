package com.baeldung.ls.client;

import com.baeldung.ls.web.dto.ProjectDto;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Set;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProjectRestApiLiveTest {

    //    public static final String BASE_URL = "http://localhost:8081/projects";
    //
    //    private RestTemplate restTemplate = new RestTemplate();
    //
    //    private MockMvc mockMvc;
    //
    //    @Autowired
    //    private WebApplicationContext context;
    //
    //    @BeforeEach
    //    public void setup() {
    //        mockMvc = MockMvcBuilders.webAppContextSetup(context)
    //                .apply(springSecurity())
    //                .build();
    //    }
    //
    //    @WithMockUser(
    //            username = "user",
    //            password = "password",
    //            roles = {"USER"})
    //    @Test
    //    public void givenProjectExists_whenGet_thenSuccess() {
    //        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "/1", ProjectDto.class);
    //
    //        MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.OK));
    //        Assertions.assertNotNull(response.getBody());
    //    }
    //
    //    @Test
    //    public void givenNewProject_whenCreate_thenSuccess() {
    //        ProjectDto newProject = new ProjectDto(null, "Live Test Project", LocalDate.now(), Set.of());
    //        ResponseEntity<Void> response = restTemplate.postForEntity(BASE_URL, newProject, Void.class);
    //
    //        MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));
    //    }
}
