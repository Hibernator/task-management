package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ProjectRepositoryImpl.class})
public class AppConfig {

    @Bean
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
}
