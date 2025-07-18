package com.baeldung.ls.spring;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    //    @Bean
    //    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //    public ProjectRepositoryInMemoryImpl2 projectRepositoryInMemory2() {
    //        return new ProjectRepositoryInMemoryImpl2();
    //    }

    // Not needed because Spring data starter automatically creates data source when H2 is on classpath
    //    @Bean
    //    public DataSource dataSource(){
    //        return new EmbeddedDatabaseBuilder()
    //                .setType(EmbeddedDatabaseType.H2)
    //                .setName("learn-spring-db")
    //                .build();
    //    }
}
