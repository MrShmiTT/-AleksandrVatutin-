package com.epam.tc.hw5.step;

import static com.epam.tc.hw5.driver.DriverSingleton.driver;

import com.epam.tc.hw5.config.ConfigProperties;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.LoginPage;
import com.epam.tc.hw5.page.UserTablePage;

public class BaseSteps {

    protected LoginPage loginPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    public static final String URL = ConfigProperties.getProperty("page");

    public BaseSteps() {
        loginPage = new LoginPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
