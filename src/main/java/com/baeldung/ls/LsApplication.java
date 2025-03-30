package com.baeldung.ls;

import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.baeldung.ls")
public class LsApplication {

    private static final Logger LOG = LoggerFactory.getLogger(LsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);

        // Not associated with the main app
        // Higher-level beans have to be scanned later
        AnnotationConfigApplicationContext differentContext = new AnnotationConfigApplicationContext(
                "com.baeldung.ls.persistence.repository", "com.baeldung.ls.spring");
        differentContext.scan("com.baeldung.ls.service");

        LOG.info("A different context created with id {}", differentContext.getId());

        IProjectService projectService = differentContext.getBean("projectServiceImpl", IProjectService.class);
        LOG.info("{}", projectService.findById(1L));

        LOG.info("Our context active before close: {}", differentContext.isActive());
        differentContext.close();
        LOG.info("Our context active after close: {}", differentContext.isActive());
    }
}
