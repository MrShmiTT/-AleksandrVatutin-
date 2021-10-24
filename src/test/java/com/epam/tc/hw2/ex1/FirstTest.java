package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        final SoftAssert softAssert = new SoftAssert();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://jdi-testing.github.io");

        //2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        //        new WebDriverWait(webDriver, Duration.ofSeconds(10)); //explicity
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234" + Keys.ENTER);

        //4. Assert Username is loggined
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertEquals(webDriver.findElement(By.linkText("HOME")).getText(), "HOME");
        softAssert.assertTrue(webDriver.findElement(By.linkText("HOME")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        softAssert.assertTrue(webDriver.findElement(By.linkText("CONTACT FORM")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        softAssert.assertTrue(webDriver.findElement(By.linkText("SERVICE")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");
        softAssert.assertTrue(webDriver.findElement(By.linkText("METALS & COLORS")).isDisplayed());

        //6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> imgs = webDriver.findElements(By.xpath("//div[@class='benefit-icon']"));
        for (WebElement img : imgs) {
            softAssert.assertTrue(img.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> imgTexts = webDriver.findElements(By.xpath("//span[@class='benefit-txt']"));
        for (WebElement imgText : imgTexts) {
            softAssert.assertTrue(imgText.isDisplayed());
        }

    }

    @AfterClass
    public void clear() {
        webDriver.close();
    }
}
