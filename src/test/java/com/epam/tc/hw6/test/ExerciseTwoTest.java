package com.epam.tc.hw6.test;

import static com.epam.tc.hw4.config.AssertsData.DIFFERENT_ELEMENTS;
import static com.epam.tc.hw4.config.AssertsData.LOGS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw6.page.DifferentElementsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different Elements page functionality")
@Story("Checking of choosing configuration and logs assertion")
public class ExerciseTwoTest extends BaseTest {

    @Test(description = "Different elements page elements")
    public void secondTest() {

        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

        //5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.goToDifferentElementsPage();
        assertThat(differentElementsPage.getTitle()).isEqualTo(DIFFERENT_ELEMENTS);

        //6. Select checkboxes Water, Wind
        differentElementsPage.selectWaterCheckbox();
        differentElementsPage.selectWindCheckbox();

        //7. Select radio Selen
        differentElementsPage.selectRadioSelen();

        //8. Select in dropdown Yellow
        differentElementsPage.selectDropDownList();
        differentElementsPage.selectYellowInDropDownList();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertThat(differentElementsPage.getLogs()).isEqualTo(LOGS);
    }
}
