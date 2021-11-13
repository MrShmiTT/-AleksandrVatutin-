package com.epam.tc.hw5.test;

import static com.epam.tc.hw5.driver.DriverSingleton.driver;

import com.epam.tc.hw5.config.ConfProperties;
import com.epam.tc.hw5.page.DifferentElements;
import com.epam.tc.hw5.page.Login;
import com.epam.tc.hw5.page.UserTablePage;

public class BaseTest {

    protected Login login;
    protected DifferentElements differentElements;
    protected UserTablePage userTablePage;
    public static final String URL = ConfProperties.getProperty("page");

    public BaseTest() {
        login = new Login(driver);
        differentElements = new DifferentElements(driver);
        userTablePage = new UserTablePage(driver);
    }
}
