package com.stt.automation;

import com.stt.utilities.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseSTT {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void initializeDriver(String browser) {
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void killSession() {
        driver.quit();
    }

    @Parameters("url")
    @BeforeTest
    public void launchApplication(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void getScreenshotIfTestFails(ITestResult iTestResult){
            if(iTestResult.getStatus() == ITestResult.FAILURE){
                SeleniumActions seleniumActions = new SeleniumActions(driver);
                seleniumActions.getScreenshot();
            }
    }
}
