package com.epam.tc.hw3.test;

import static com.epam.tc.hw3.config.AssertsData.DIFFERENT_ELEMENTS;
import static com.epam.tc.hw3.config.AssertsData.LOGS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.page.DifferentElements;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test
    public void secondTest() {

        DifferentElements differentElements = new DifferentElements(driver);

        //5. Open through the header menu Service -> Different Elements Page
        differentElements.goToDifferentElementsPage();
        assertThat(differentElements.getTitle()).isEqualTo(DIFFERENT_ELEMENTS);

        //6. Select checkboxes Water, Wind
        differentElements.selectWaterCheckbox();
        differentElements.selectWindCheckbox();

        //7. Select radio Selen
        differentElements.selectRadioSelen();

        //8. Select in dropdown Yellow
        differentElements.selectDropDownList();
        differentElements.selectYellowInDropDownList();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertThat(differentElements.getLogs()).isEqualTo(LOGS);
    }
}
