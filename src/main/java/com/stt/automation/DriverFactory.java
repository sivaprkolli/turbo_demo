package com.stt.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(){
        driver = new ChromeDriver();
        return driver;
    }
}
