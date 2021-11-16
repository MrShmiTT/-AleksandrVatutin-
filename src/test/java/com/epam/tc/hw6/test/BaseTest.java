package com.epam.tc.hw6.test;

import com.epam.tc.hw6.config.AssertsData;
import com.epam.tc.hw6.config.ConfProperties;
import com.epam.tc.hw6.page.Login;
import com.epam.tc.hw6.webdriver.WebDriverProvider;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    public static final String URL = ConfProperties.getProperty("page");
    public SoftAssert softAssert = new SoftAssert();

    @BeforeClass(description = "Setting up test env and perform Login")
    public void setUp(ITestContext testContext) {
        driver = WebDriverProvider.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        testContext.setAttribute("driver", driver);

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

    @AfterClass(alwaysRun = true, description = "Quite browser")
    public void stopBrowser() {
        WebDriverProvider.closeDriver();
    }
}
