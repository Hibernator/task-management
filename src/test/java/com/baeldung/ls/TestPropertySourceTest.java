package com.baeldung.ls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(value = LsApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
@ActiveProfiles("dev")
public class TestPropertySourceTest {

    @Value("${test.property}")
    private String testproperty;

    @Value("${additional.info}")
    private String additionalInfo;

    @Test
    public void whenTestPropertySource_thenValuesRetreived() {
        assertEquals("Test Property Value", testproperty);
    }

    @Test
    public void whenPropertyRedefinedInTest_thenHasPrecedence() {
        assertEquals("Additional Info Test Value", additionalInfo);
    }
}
