package com.baeldung.ls;

import com.baeldung.ls.persistence.model.ProjectInMemory;
import com.baeldung.ls.persistence.repository.IProjectRepositoryInMemory;
import com.baeldung.ls.service.impl.ProjectServiceInMemoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Now there is not need to initialize mocks manually
public class ProjectInMemoryServiceAlternativeUnitTest {

    @Mock
    IProjectRepositoryInMemory projectRepositoryInMemory;

    @InjectMocks
    ProjectServiceInMemoryImpl projectService;

    @Test
    public void whenSavingProject_thenOK() {
        ProjectInMemory projectInMemory = new ProjectInMemory(2L, "name", LocalDate.now());
        when(projectRepositoryInMemory.save(projectInMemory)).thenReturn(projectInMemory);

        ProjectInMemory savedProjectInMemory = projectService.save(projectInMemory);

        assertNotNull(savedProjectInMemory);
    }
}
