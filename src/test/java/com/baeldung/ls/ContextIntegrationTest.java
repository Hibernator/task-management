package com.baeldung.ls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ContextIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void whenContextIsLoaded_thenNoExceptions() {}

    @Test
    void whenContextIsLoaded_thenNoExceptions2() {
        // The context is caches so the second test runs much faster
    }
}
