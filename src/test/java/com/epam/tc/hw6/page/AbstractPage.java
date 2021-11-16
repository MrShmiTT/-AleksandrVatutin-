package com.epam.tc.hw6.page;

import com.epam.tc.hw6.webdriver.WebDriverProvider;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = WebDriverProvider.getDriver();
    }
}
