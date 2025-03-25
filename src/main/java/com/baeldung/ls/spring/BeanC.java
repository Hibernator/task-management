package com.baeldung.ls.spring;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanC {
    public static final Logger log = LoggerFactory.getLogger(BeanC.class);

    @PreDestroy
    public void preDestroy() {
        log.info("BeanC preDestroy");
    }

    public void destroy() {
        log.info("BeanC destroy");
    }
}
