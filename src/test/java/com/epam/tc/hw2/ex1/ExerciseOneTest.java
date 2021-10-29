package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.AssertsData.HEADER_BUTTONS;
import static com.epam.tc.hw2.AssertsData.SIDE_BUTTONS;
import static com.epam.tc.hw2.AssertsData.TEXTS;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    @Test
    public void firstTest() {
        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerButtons = webDriver.findElements(By.xpath("//header/div/nav/ul[1]/li"));
        headerButtons.forEach(button -> softAssert.assertTrue(button.isDisplayed()));
        softAssert.assertEquals(headerButtons.stream().map(WebElement::getText).collect(Collectors.toList()),
            HEADER_BUTTONS);

        //6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> imgs = webDriver.findElements(By.xpath("//div[@class='benefit-icon']"));
        for (WebElement img : imgs) {
            softAssert.assertTrue(img.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> imgElements = webDriver.findElements(By.xpath("//span[@class='benefit-txt']"));
        imgElements.forEach(imgText -> softAssert.assertTrue(imgText.isDisplayed()));
        softAssert.assertEquals(imgElements.stream().map(WebElement::getText).collect(Collectors.toList()), TEXTS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        WebElement frameBtn = webDriver.findElement(By.cssSelector("#frame-button"));
        softAssert.assertEquals(frameBtn.getAttribute("value"), "Frame Button");
        softAssert.assertTrue(frameBtn.isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> sideButtons = webDriver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li"));
        sideButtons.forEach(button -> softAssert.assertTrue(button.isDisplayed()));
        softAssert.assertEquals(sideButtons.stream().map(WebElement::getText).collect(Collectors.toList()),
            SIDE_BUTTONS);

        //12. Close Browser
        softAssert.assertAll();
    }
}
