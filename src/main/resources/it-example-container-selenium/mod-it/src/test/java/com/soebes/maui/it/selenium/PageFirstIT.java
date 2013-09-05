package com.soebes.maui.it.selenium;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;

import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PageFirstIT extends PageBase {

    @BeforeSuite
    public void beforeSuite() {
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile firefoxProfile = allProfiles.getProfile("webtest");
		
		assertThat(firefoxProfile).isNotNull();

		firefoxProfile.setEnableNativeEvents(true);

		FirefoxDriver firefoxDriver = new FirefoxDriver(
			new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")), 
			firefoxProfile
		);

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
        assertThat(getDriver().getTitle()).isEqualTo("Wicket Quickstart Archetype Homepage");
    }
}
