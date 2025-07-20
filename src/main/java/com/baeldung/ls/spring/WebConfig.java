package com.baeldung.ls.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Not needed because spring-boot-starter-web already includes @EnableWebMvc
// @EnableWebMvc
@Configuration
// @ComponentScan(basePackages = {"com.baeldung.ls.web.controller"})
public class WebConfig {}
