package com.baeldung.ls;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.impl.ProjectServiceImpl;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.baeldung.ls")
public class LsApplication implements CommandLineRunner {
    // CommandLineRunner is used to execute code after the application context is loaded

    private static final Logger LOG = LoggerFactory.getLogger(LsApplication.class);

    @Autowired
    IProjectService projectService;

    @Value("${additional.info}")
    private String additionalInfo;

    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);

        // Not associated with the main app
        // Higher-level beans have to be scanned later
        System.setProperty("spring.profiles.active", "dev");
        AnnotationConfigApplicationContext differentContext = new AnnotationConfigApplicationContext(
                "com.baeldung.ls.persistence.repository", "com.baeldung.ls.spring");
        differentContext.scan("com.baeldung.ls.service");

        LOG.info("A different context created with id {}", differentContext.getId());

        //        IProjectService projectService = differentContext.getBean("projectServiceImpl",
        // ProjectServiceImpl.class);
        //        LOG.info("{}", projectService.findById(1L));

        LOG.info("Our context active before close: {}", differentContext.isActive());
        differentContext.close();
        LOG.info("Our context active after close: {}", differentContext.isActive());
    }

    @PostConstruct
    public void init() {
        projectService.save(new Project("My First Project", LocalDate.now()));
        Optional<Project> project = projectService.findByName("My First Project");
        project.ifPresent(System.out::println);

        LOG.info("Additional info: {}", additionalInfo);
    }

    @Override
    public void run(String... args) throws Exception {
        projectService.save(new Project("Project 1", LocalDate.now()));
        Optional<Project> project = projectService.findByName("Project 1");
        LOG.info("Project {}", project.toString());
    }
}
