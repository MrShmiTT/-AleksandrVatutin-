package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver webDriver;
    protected SoftAssert softassert;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softassert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. Open test site by URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        softassert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234" + Keys.ENTER);

        //4. Assert Username is loggined
        softassert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    @AfterClass
    public void clear() {
        webDriver.quit();
    }
}
