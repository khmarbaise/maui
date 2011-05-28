package com.soebes.training.module.ut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class ImplementationUnitTest {

    protected static IFunction function;

    @Test
    public void firstTest() {
        assertTrue(function.function("function1"));
    }

    @Test
    public void secondTest() {
        assertFalse(function.function("function"));
    }
}
