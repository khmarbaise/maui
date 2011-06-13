package com.soebes.maui.ut.inter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.soebes.maui.ut.inter.IFunction;

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
