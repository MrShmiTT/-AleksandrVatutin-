package com.epam.tc.hw2.ex1;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    private WebElement webElement;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("https://jdi-testing.github.io");
        Assert.assertEquals("Home Page", webDriver.getTitle());
        webElement = webDriver.findElement(By.id("user-icon"));
        webElement.click();
//        new WebDriverWait(webDriver, Duration.ofSeconds(10)); //explicity
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234" + Keys.ENTER);

        webElement = webDriver.findElement(By.xpath("//span[not(@class=\"hidden\") and text()=\"Roman Iovlev\"]"));
        Assert.assertEquals("Roman Iovlev", webElement.getText());
    }

    @AfterMethod
    public void clear() {
        webDriver.close();
    }
}
