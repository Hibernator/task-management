package com.baeldung.ls.client;

import com.baeldung.ls.web.dto.ProjectDto;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProjectRestApiLiveTest {

    public static final String BASE_URL = "http://localhost:8081/projects";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void givenProjectExists_whenGet_thenSuccess() {
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "/1", ProjectDto.class);

        MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void givenNewProject_whenCreate_thenSuccess() {
        ProjectDto newProject = new ProjectDto(null, "Live Test Project", LocalDate.now(), Set.of());
        ResponseEntity<Void> response = restTemplate.postForEntity(BASE_URL, newProject, Void.class);

        MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));
    }
}
