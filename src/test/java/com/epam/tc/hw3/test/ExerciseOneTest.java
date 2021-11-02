package com.epam.tc.hw3.test;

import static com.epam.tc.hw3.config.AssertsData.FRAME_BTN;
import static com.epam.tc.hw3.config.AssertsData.HEADER_BUTTONS;
import static com.epam.tc.hw3.config.AssertsData.SIDE_BUTTONS;
import static com.epam.tc.hw3.config.AssertsData.TEXTS;

import com.epam.tc.hw3.page.HeaderMenu;
import com.epam.tc.hw3.page.SideMenu;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    @Test
    public void firstTest() {

        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        HeaderMenu headerMenu = new HeaderMenu(driver);
        softAssert.assertTrue(headerMenu.areHeaderButtonsDisplayed());
        softAssert.assertEquals(headerMenu.getHeaderButtonsText(), HEADER_BUTTONS);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertTrue(headerMenu.areImagesDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertTrue(headerMenu.areImageTextDisplayed());
        softAssert.assertEquals(headerMenu.getImageTexts(), TEXTS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(headerMenu.areFrameDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        headerMenu.switchToFrame();
        softAssert.assertEquals(headerMenu.getFrameButton(), FRAME_BTN);

        //10. Switch to original window back
        headerMenu.switchToParentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        SideMenu sideMenu = new SideMenu(driver);
        softAssert.assertTrue(sideMenu.areSideButtonsDisplayed());
        softAssert.assertEquals(sideMenu.getSideButtons(), SIDE_BUTTONS);

        //12. Close Browser
        softAssert.assertAll();
    }
}
