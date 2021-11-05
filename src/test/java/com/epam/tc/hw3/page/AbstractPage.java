package com.epam.tc.hw3.page;

import com.epam.tc.hw3.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
    }
}
