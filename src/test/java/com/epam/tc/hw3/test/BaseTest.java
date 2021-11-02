package com.epam.tc.hw3.test;

import com.epam.tc.hw3.config.AssertsData;
import com.epam.tc.hw3.config.ConfProperties;
import com.epam.tc.hw3.driver.DriverSingleton;
import com.epam.tc.hw3.page.Login;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    public static final String URL = ConfProperties.getProperty("page");
    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. Open test site by URL
        Login login = new Login(driver);
        login.open(URL);
        softAssert.assertEquals(driver.getCurrentUrl(), URL);

        //2. Assert Browser title
        softAssert.assertEquals(login.getPageTitle(), AssertsData.HOME);

        //3. Perform login
        login.login();

        //4. Assert Username is loggined
        softAssert.assertEquals(login.getFullUserName(), AssertsData.FULL_USER_NAME);

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
