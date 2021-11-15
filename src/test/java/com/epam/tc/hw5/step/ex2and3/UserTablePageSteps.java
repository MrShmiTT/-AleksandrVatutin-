package com.epam.tc.hw5.step.ex2and3;

import static com.epam.tc.hw4.config.AssertsData.LOGS_USER_TABLE;
import static com.epam.tc.hw5.config.AssertsData.USER_TABLE;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.step.BaseSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class UserTablePageSteps extends BaseSteps {

    @When("I click on 'Service' button in Header")
    public void clickOnServiceButton() {
        userTablePage.clickOnServiceButton();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableButton() {
        userTablePage.clickOnUserTableButton();
    }

    @Then("'User Table' page should be opened")
    public void assertUserPageTitle() {
        assertThat(loginPage.getPageTitle()).isEqualTo(USER_TABLE);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void areDropdownsDisplayed(int number) {
        assertThat(userTablePage.countDropdownsNumber()).isEqualTo(number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void areUserNamesDisplayed(int number) {
        assertThat(userTablePage.countUsersNumber()).isEqualTo(number);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void areUserDescriptionsDisplayed(int number) {
        assertThat(userTablePage.countDescriptionsNumber()).isEqualTo(number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void areCheckBoxesDisplayed(int number) {
        assertThat(userTablePage.countCheckBoxesNumber()).isEqualTo(number);
    }

    @Then("User table should contain following values:")
    public void userTableAssert(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists(String.class);
        List<List<String>> tableWithoutHeader = new ArrayList<>(expectedTable);
        tableWithoutHeader.remove(0);
        assertThat(userTablePage.getUserTable()).isEqualTo(tableWithoutHeader);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void userRolesAssert(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists(String.class);
        List<List<String>> tableWithoutHeader = new ArrayList<>(expectedTable);
        tableWithoutHeader.remove(0);
        List<String> res = new ArrayList<>();
        tableWithoutHeader.forEach(res::addAll);
        assertThat(userTablePage.getUserRoles()).isEqualTo(res);
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckBox() {
        userTablePage.clickOnCheckBoxIvan();
    }

    @Then("1 log row has 'Vip: condition changed to true' text in log section")
    public void assertUserTableLogs() {
        assertThat(userTablePage.getLogsUserTable()).isEqualTo(LOGS_USER_TABLE);
    }
}
