package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AssertsData;
import com.epam.tc.hw2.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test
    public void secondTest() {
        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.linkText("SERVICE")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        softassert.assertEquals(webDriver.getTitle(), "Different Elements");

        //6. Select checkboxes Water, Wind
        webDriver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        webDriver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();

        //7. Select radio Selen
        webDriver.findElement(By.xpath("//label[@class='label-radio'][4]")).click();

        //8. Select in dropdown Yellow
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logTxts = webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        softassert.assertTrue(logTxts.get(0).getText().contains(AssertsData.LOG_ONE));
        softassert.assertTrue(logTxts.get(1).getText().contains(AssertsData.LOG_TWO));
        softassert.assertTrue(logTxts.get(2).getText().contains(AssertsData.LOG_THREE));
        softassert.assertTrue(logTxts.get(3).getText().contains(AssertsData.LOG_FOUR));

        //10. Close Browser
        softassert.assertAll();
    }
}
