package com.soebes.maui.ut.inter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest {

    @Test
    public void firstTest() {
    	Implementation function = new Implementation();
        assertTrue(function.function("function1"));
    }

    @Test
    public void secondTest() {
        assertFalse(function.function("function"));
    }
}
