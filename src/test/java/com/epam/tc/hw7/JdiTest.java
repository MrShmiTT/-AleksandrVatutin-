package com.epam.tc.hw7;

import static com.epam.tc.hw7.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.pages.HomePage.metalsAndColorsHeader;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.MetalsAndColorsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        String actualFullName = JdiSite.getUserName();
        Assert.assertEquals(actualFullName, User.ROMAN.getFullName());
        metalsAndColorsHeader.click();
        metalsAndColorsPage.checkOpened();

    }
}
