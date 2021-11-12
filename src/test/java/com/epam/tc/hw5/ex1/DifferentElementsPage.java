package com.epam.tc.hw5.ex1;

import static com.epam.tc.hw5.config.AssertsData.LOGS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.page.DifferentElements;
import com.epam.tc.hw5.page.Login;
import com.epam.tc.hw5.test.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DifferentElementsPage extends BaseTest {

    DifferentElements differentElements = new DifferentElements(driver);
    Login login = new Login(driver);

    //1. Open test site by URL
    @Given("I open JDI home page")
    public void openHomePage() {
        login.open(URL);
    }

    //2. Perform login
    @Given("I perform login as 'Roman Iovlev'")
    public void performLogin() {
        login.login();
    }

    //3. Open through the header menu Service -> Different Elements Page
    @When("I follow on 'Different elements page' throw the header menu")
    public void openDiffElementsPage() {
        differentElements.goToDifferentElementsPage();
    }

    //4. Select checkboxes Water, Wind
    @When("I select 'Water' checkbox on the Different elements page")
    public void selectWaterCheckbox() {
        differentElements.selectWaterCheckbox();
    }

    @When("I select 'Wind' checkbox on the Different elements page")
    public void selectWindCheckbox() {
        differentElements.selectWindCheckbox();
    }

    //5. Select radio Selen
    @When("I select 'Selen' radio on the Different elements page")
    public void selectSelenRadio() {
        differentElements.selectRadioSelen();
    }

    //6. Select in dropdown Yellow
    @When("I click on dropdown list on the Different elements page")
    public void selectDropDOwnList() {
        differentElements.selectDropDownList();
    }

    @When("I select Yellow color in dropdown list on the Different elements page")
    public void selectYellowInDropDownList() {
        differentElements.selectYellowInDropDownList();
    }

    //7. Assert that
    //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    //for radio button there is a log row and value is corresponded to the status of radio button
    //for dropdown there is a log row and value is corresponded to the selected value.

    @Then("logs are displayed and have proper rows")
    public void assertLogs() {
        assertThat(differentElements.getLogs()).isEqualTo(LOGS);
    }
}
