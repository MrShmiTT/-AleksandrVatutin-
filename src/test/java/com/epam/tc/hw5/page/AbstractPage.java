package com.epam.tc.hw5.page;

import com.epam.tc.hw5.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
    }
}
