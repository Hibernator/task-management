package com.baeldung.ls.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CustomBeanPostProcessor implements BeanPostProcessor, Ordered {

    private static Logger LOG = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //        LOG.info("CustomBeanPostProcessor is invoked before initializing the bean {}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //        LOG.info("CustomBeanPostProcessor is invoked after initializing the bean {}", beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
