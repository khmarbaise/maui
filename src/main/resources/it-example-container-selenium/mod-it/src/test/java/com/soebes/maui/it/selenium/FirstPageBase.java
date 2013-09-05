package com.soebes.maui.it.selenium;

import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirstPageBase extends PageBase {
    
    public FirstPageBase() {
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile firefoxProfile = allProfiles.getProfile("webtest");
        setDriver(new FirefoxDriver(firefoxProfile));
        String baseURL = "http://localhost:9080/mod-war/";
        getDriver().get(baseURL);
        setSelenium(new WebDriverBackedSelenium(getDriver(), baseURL));
        
        getSelenium().deleteAllVisibleCookies();
        getSelenium().setBrowserLogLevel("warn");
        getSelenium().setSpeed("200");
    }
}
