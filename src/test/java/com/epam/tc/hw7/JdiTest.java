package com.epam.tc.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.JdiMetalsAndColorsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JdiTest {

    public JdiMetalsAndColorsPage jdiMetalsAndColorsPage;

    @BeforeClass
    public void beforeClass() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        String actualFullName = JdiSite.getUserName();
        Assert.assertEquals(actualFullName, User.ROMAN.getFullName());
        //        jdiMetalsAndColorsPage.goToMetalsAndColorsPage();
        //        Assert.assertEquals(jdiMetalsAndColorsPage.getPage().title);
    }
}
