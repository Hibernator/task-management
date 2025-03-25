package com.baeldung.ls.spring;

import jakarta.annotation.PostConstruct;

public class BeanA {

    @PostConstruct
    public void post() {
        System.out.println("BeanA.post()");
    }
}
