package com.epam.tc.hw5.step.ex1;

import static com.epam.tc.hw5.config.AssertsData.LOGS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.step.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DifferentElementsPageSteps extends BaseSteps {

    //3. Open through the header menu Service -> Different Elements Page
    @When("I follow on 'Different elements page' throw the header menu")
    public void openDiffElementsPage() {
        differentElementsPage.goToDifferentElementsPage();
    }

    //4. Select checkboxes Water, Wind
    @When("I select {string} checkbox on the Different elements page")
    public void selectCheckBox(String checkboxName) {
        differentElementsPage.selectCheckBox(checkboxName);
    }

    //5. Select radio Selen
    @When("I select 'Selen' radio on the Different elements page")
    public void selectSelenRadio() {
        differentElementsPage.selectRadioSelen();
    }

    //6. Select in dropdown Yellow
    @When("I click on dropdown list on the Different elements page")
    public void selectDropDOwnList() {
        differentElementsPage.selectDropDownList();
    }

    @When("I select Yellow color in dropdown list on the Different elements page")
    public void selectYellowInDropDownList() {
        differentElementsPage.selectYellowInDropDownList();
    }

    //7. Assert that
    //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    //for radio button there is a log row and value is corresponded to the status of radio button
    //for dropdown there is a log row and value is corresponded to the selected value.
    @Then("logs are displayed and have proper rows")
    public void assertLogs() {
        assertThat(differentElementsPage.getLogs()).isEqualTo(LOGS);
    }
}
