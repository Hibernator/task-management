package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ProjectRepositoryImpl.class})
public class AppConfig {
}
