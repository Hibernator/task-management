package com.baeldung.ls;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.baeldung.ls")
public class LsApplication implements CommandLineRunner {
    // CommandLineRunner is used to execute code after the application context is loaded

    private static final Logger LOG = LoggerFactory.getLogger(LsApplication.class);

    @Autowired
    IProjectService projectService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${additional.info}")
    private String additionalInfo;

    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }

    @PostConstruct
    public void init() {
        //        projectService.save(new Project("My First Project", LocalDate.now()));
        //        Optional<Project> project = projectService.findById(1L);
        //        project.ifPresent(System.out::println);
        //
        //        LOG.info("Additional info: {}", additionalInfo);
    }

    @Override
    public void run(String... args) {
        jdbcTemplate.execute("CREATE TABLE project(id SERIAL, name VARCHAR(255), date_created DATE)");
    }
}
