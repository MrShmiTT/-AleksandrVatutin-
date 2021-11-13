package com.epam.tc.hw5.test;

import com.epam.tc.hw5.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
