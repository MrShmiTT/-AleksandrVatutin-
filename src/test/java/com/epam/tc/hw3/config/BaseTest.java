package com.epam.tc.hw3.config;

import com.epam.tc.hw3.driver.DriverSingleton;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    public static final String URL = ConfProperties.getProperty("page");

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
