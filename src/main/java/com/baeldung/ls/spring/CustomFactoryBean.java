package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CustomFactoryBean implements FactoryBean<ProjectRepositoryImpl> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFactoryBean.class);

    @Override
    public ProjectRepositoryImpl getObject() throws Exception {
        LOG.info("Creating Project Repository");
        return new ProjectRepositoryImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return ProjectRepositoryImpl.class;
    }
}
