package com.baeldung.ls.aspect;

import com.baeldung.ls.persistence.model.Project;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class ProjectServiceAspect {

    public static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        LOG.info("Searching project with id {}", joinPoint.getArgs()[0]);
    }

    // returning parameter matches the method argument name
    @AfterReturning(pointcut = "execution(*..Optional<*..Project>  *..service..findById(*))", returning = "project")
    public void afterReturningProject(Optional<Project> project) {
        LOG.info("Project found: {}", project.orElse(null));
    }

    // within: all methods declared within the specified type
    @After("within(com.baeldung.ls.service.impl.ProjectServiceImpl)")
    public void afterAllMethodsOfProjectServiceImpl(JoinPoint joinPoint) {
        LOG.info("After invoking the method: {}", joinPoint.getSignature().getName());
    }

    @Around("execution(* com.baeldung.ls.service.impl.ProjectServiceImpl.save(*))")
    public Object aroundSave(ProceedingJoinPoint joinPoint) {
        Object value = joinPoint.getArgs()[0];
        try {
            LOG.info("Saving project: {}", value);
            value = joinPoint.proceed();
            LOG.info("Project saved successfully");
        } catch (Throwable throwable) {
            LOG.error("Error while saving project ", throwable);
        }
        return value;
    }
}
