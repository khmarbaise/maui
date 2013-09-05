package com.soebes.maui.it.selenium;

import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Selenium;

public class PageBase {

    private WebDriver driver;

    private Selenium selenium;

    public PageBase(WebDriver driver, Selenium selenium) {
        super();
        this.driver = driver;
        this.selenium = selenium;
    }

    public PageBase() {
        super();
        this.driver = null;
        this.selenium = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Selenium getSelenium() {
        return selenium;
    }

    public void setSelenium(Selenium selenium) {
        this.selenium = selenium;
    }

}
