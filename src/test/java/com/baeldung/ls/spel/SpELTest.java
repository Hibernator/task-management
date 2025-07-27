package com.baeldung.ls.spel;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SpELTest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void whenSpElBeanAIsInjected_thenExpressionIsResolvedCorrectly() {
        // This test will pass if the SpEL expression in SpELBeanA is resolved correctly
        // and the add field is set to 5 (2 + 3).
        MatcherAssert.assertThat(spELBeanA.getAdd(), CoreMatchers.is(5));
        MatcherAssert.assertThat(spELBeanA.getAddString(), CoreMatchers.is("LearnSpring"));
        assertTrue(spELBeanA.isEqual());
        MatcherAssert.assertThat(spELBeanA.getTernary(), CoreMatchers.is("a"));
        MatcherAssert.assertThat(spELBeanA.getOtherBeanProperty(), CoreMatchers.is("10"));
    }
}
