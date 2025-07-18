package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDataLoader implements ApplicationContextAware {

    private final IProjectRepository projectRepository;

    public TestDataLoader(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(RandomStringUtils.secure().next(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.secure().next(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.secure().next(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.secure().next(6), LocalDate.now()));
    }
}
