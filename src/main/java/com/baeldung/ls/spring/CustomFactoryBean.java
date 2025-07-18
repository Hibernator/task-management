package com.baeldung.ls.spring;

import com.baeldung.ls.actuate.health.DbHealthIndicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CustomFactoryBean implements FactoryBean<DbHealthIndicator> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFactoryBean.class);

    @Override
    public DbHealthIndicator getObject() throws Exception {
        //        LOG.info("Creating ProjectServiceImpl instance using CustomFactoryBean");
        return new DbHealthIndicator();
    }

    @Override
    public Class<?> getObjectType() {
        return DbHealthIndicator.class;
    }
}
