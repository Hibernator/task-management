package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryInMemoryImpl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CustomFactoryBean implements FactoryBean<ProjectRepositoryInMemoryImpl2> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFactoryBean.class);

    @Override
    public ProjectRepositoryInMemoryImpl2 getObject() throws Exception {
        LOG.info("Creating Project Repository In Memory Implementation 2");
        return new ProjectRepositoryInMemoryImpl2();
    }

    @Override
    public Class<?> getObjectType() {
        return ProjectRepositoryInMemoryImpl2.class;
    }
}
