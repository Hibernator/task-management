package com.baeldung.ls.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Import({PersistenceConfig.class})
@PropertySource("classpath:additional.properties")
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private Environment environment;

    // Static so that it's created really early in the container lifecycle
    @Bean
    public static CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean
    @Profile("dev")
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod = "initialize")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(destroyMethod = "destroy")
    public BeanC beanC() {
        return new BeanC();
    }

    // Thanks to this, the default ObjectMapper from JacksonAutoConfiguration won't be created
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @PostConstruct
    private void init() {
        LOG.info("Project suffix: {}", environment.getProperty("project.suffix"));
        LOG.info("Active profiles: {}", environment.getProperty("spring.profiles.active"));
    }
}
