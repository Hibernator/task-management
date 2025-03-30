package com.baeldung.ls.spring;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {

    private static final Logger LOG = LoggerFactory.getLogger(BeanA.class);

    private String foo;

    @PostConstruct
    public void post() {
        LOG.info("PostConstruct BeanA");
        LOG.info("BeanA foo: {}", foo);
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
