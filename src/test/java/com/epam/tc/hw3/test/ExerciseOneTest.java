package com.epam.tc.hw3.test;

import static com.epam.tc.hw3.config.AssertsData.HEADER_BUTTONS;

import com.epam.tc.hw3.config.AssertsData;
import com.epam.tc.hw3.config.BaseTest;
import com.epam.tc.hw3.page.CommonLogin;
import com.epam.tc.hw3.page.HeaderMenu;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseOneTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void firstTest() {

        CommonLogin commonLogin = new CommonLogin(driver);

        commonLogin.open(URL);
        softAssert.assertEquals(driver.getCurrentUrl(), URL);

        //2. Assert Browser title
        softAssert.assertEquals(commonLogin.getPageTitle(), AssertsData.HOME);

        //3. Perform login
        commonLogin.login();

        //4. Assert Username is loggined
        softAssert.assertEquals(commonLogin.getFullUserName(), AssertsData.FULL_USER_NAME);

        HeaderMenu headerMenu = new HeaderMenu(driver);

        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        headerMenu.getHeaderButtons();
        softAssert.assertTrue(headerMenu.getHeaderButtons());
        softAssert.assertEquals(headerMenu.getHeaderButtonsText(), HEADER_BUTTONS);


//        List<WebElement> headerButtons = driver.findElements(By.xpath("//header/div/nav/ul[1]/li"));
//        headerButtons.forEach(button -> softAssert.assertTrue(button.isDisplayed()));
//        softAssert.assertEquals(headerButtons.stream().map(WebElement::getText).collect(Collectors.toList()),
//            HEADER_BUTTONS);
//
//        //6. Assert that there are 4 images on the Index Page, and they are displayed
//        List<WebElement> imgs = driver.findElements(By.xpath("//div[@class='benefit-icon']"));
//        for (WebElement img : imgs) {
//            softAssert.assertTrue(img.isDisplayed());
//        }
//
//        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
//        List<WebElement> imgElements = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
//        imgElements.forEach(imgText -> softAssert.assertTrue(imgText.isDisplayed()));
//        softAssert.assertEquals(imgElements.stream().map(WebElement::getText).collect(Collectors.toList()), TEXTS);
//
//        //8. Assert that there is the iframe with “Frame Button” exist
//        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());
//
//        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
//        driver.switchTo().frame("frame");
//        WebElement frameBtn = driver.findElement(By.cssSelector("#frame-button"));
//        softAssert.assertEquals(frameBtn.getAttribute("value"), "Frame Button");
//        softAssert.assertTrue(frameBtn.isDisplayed());
//
//        //10. Switch to original window back
//        driver.switchTo().parentFrame();
//
//        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
//        List<WebElement> sideButtons = driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li"));
//        sideButtons.forEach(button -> softAssert.assertTrue(button.isDisplayed()));
//        softAssert.assertEquals(sideButtons.stream().map(WebElement::getText).collect(Collectors.toList()),
//            SIDE_BUTTONS);

        //12. Close Browser
        softAssert.assertAll();
    }
}
