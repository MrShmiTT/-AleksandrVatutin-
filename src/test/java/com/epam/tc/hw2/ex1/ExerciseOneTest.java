package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AssertsData;
import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    @Test
    public void firstTest() {
        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softassert.assertEquals(webDriver.findElement(By.linkText("HOME")).getText(), "HOME");
        softassert.assertTrue(webDriver.findElement(By.linkText("HOME")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        softassert.assertTrue(webDriver.findElement(By.linkText("CONTACT FORM")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        softassert.assertTrue(webDriver.findElement(By.linkText("SERVICE")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");
        softassert.assertTrue(webDriver.findElement(By.linkText("METALS & COLORS")).isDisplayed());

        //6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> imgs = webDriver.findElements(By.xpath("//div[@class='benefit-icon']"));
        for (WebElement img : imgs) {
            softassert.assertTrue(img.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> imgTexts = webDriver.findElements(By.xpath("//span[@class='benefit-txt']"));
        for (WebElement imgText : imgTexts) {
            softassert.assertTrue(imgText.isDisplayed());
        }
        softassert.assertEquals(imgTexts.get(0).getText(), AssertsData.TEXT_ONE);
        softassert.assertEquals(imgTexts.get(1).getText(), AssertsData.TEXT_TWO);
        softassert.assertEquals(imgTexts.get(2).getText(), AssertsData.TEXT_THREE);
        softassert.assertEquals(imgTexts.get(3).getText(), AssertsData.TEXT_FOUR);

        //8. Assert that there is the iframe with “Frame Button” exist
        softassert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        WebElement framebtn = webDriver.findElement(By.cssSelector("#frame-button"));
        softassert.assertEquals(framebtn.getAttribute("value"), "Frame Button");
        softassert.assertTrue(framebtn.isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softassert.assertEquals(webDriver.findElement(By.linkText("Home")).getText(), "Home");
        softassert.assertTrue(webDriver.findElement(By.linkText("Home")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("Contact form")).getText(), "Contact form");
        softassert.assertTrue(webDriver.findElement(By.linkText("Contact form")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("Service")).getText(), "Service");
        softassert.assertTrue(webDriver.findElement(By.linkText("Service")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("Metals & Colors")).getText(), "Metals & Colors");
        softassert.assertTrue(webDriver.findElement(By.linkText("Metals & Colors")).isDisplayed());

        softassert.assertEquals(webDriver.findElement(By.linkText("Elements packs")).getText(), "Elements packs");
        softassert.assertTrue(webDriver.findElement(By.linkText("Elements packs")).isDisplayed());

        //12. Close Browser
        softassert.assertAll();
    }
}
