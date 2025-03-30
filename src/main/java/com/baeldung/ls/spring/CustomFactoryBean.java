package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CustomFactoryBean implements FactoryBean<ProjectRepositoryImpl2> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFactoryBean.class);

    @Override
    public ProjectRepositoryImpl2 getObject() throws Exception {
        LOG.info("Creating Project Repository");
        return new ProjectRepositoryImpl2();
    }

    @Override
    public Class<?> getObjectType() {
        return ProjectRepositoryImpl2.class;
    }
}
