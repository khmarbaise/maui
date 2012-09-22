package com.soebes.maui.it.c;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ContainerIT {
    private WebTester wt;

    @BeforeClass
    public void prepare() {
        wt = new WebTester();
        wt.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        wt.setBaseUrl("http://localhost:9080/mod-war/");
    }

    @Test
    public void test1() {
        wt.beginAt("/");
        wt.assertTitleEquals("Wicket Quickstart Archetype Homepage");
    }
}
