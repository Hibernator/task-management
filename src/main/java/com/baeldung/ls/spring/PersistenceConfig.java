package com.baeldung.ls.spring;

import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryInMemoryImpl2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersistenceConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ProjectRepositoryInMemoryImpl2 projectRepositoryInMemory2() {
        return new ProjectRepositoryInMemoryImpl2();
    }

    // Not needed because Spring data starter automatically creates data source when H2 is on classpath
    //    @Bean
    //    public DataSource dataSource(){
    //        return new EmbeddedDatabaseBuilder()
    //                .setType(EmbeddedDatabaseType.H2)
    //                .setName("learn-spring-db")
    //                .build();
    //    }
}
