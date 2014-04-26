package com.soebes.maui.it.selenium;

import static org.fest.assertions.Assertions.assertThat;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class PageFirstIT extends PageBase {

    @BeforeSuite
    public void beforeSuite() {
	FirefoxDriver firefoxDriver = new FirefoxDriver();

	setDriver(firefoxDriver);
	String baseURL = "http://localhost:9080/";
	setSelenium(new WebDriverBackedSelenium(getDriver(), baseURL));

	getSelenium().deleteAllVisibleCookies();
	getSelenium().setBrowserLogLevel("warn");
	getSelenium().open("/mod-war/");
	getSelenium().waitForPageToLoad("30000");
	getSelenium().setSpeed("200");
    }

    @AfterSuite
    public void afterSuite() {
	getSelenium().stop();
    }

    @Test
    public void firstTest() {
	assertThat(getDriver().getTitle()).isEqualTo(
		"Wicket Quickstart Archetype Homepage");
    }
}
