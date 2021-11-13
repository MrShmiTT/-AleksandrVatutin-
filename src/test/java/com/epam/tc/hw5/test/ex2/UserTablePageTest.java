package com.epam.tc.hw5.test.ex2;

import static com.epam.tc.hw5.config.AssertsData.USER_TABLE;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.test.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;

public class UserTablePageTest extends BaseTest {

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
        assertThat(login.getPageTitle()).isEqualTo(USER_TABLE);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void areDropdownsDisplayed(int number) {
        assertThat(userTablePage.countDescriptionsNumber()).isEqualTo(number);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void areUserNamesDisplayed(int number) {
        assertThat(userTablePage.countUsersNumber()).isEqualTo(number);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void areUserDescriptionsDisplayed(int number) {
        assertThat(userTablePage.countDescriptionsNumber()).isEqualTo(number);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void areCheckBoxesDisplayed(int number) {
        assertThat(userTablePage.countCheckBoxesNumber()).isEqualTo(number);
    }

    @And("User table should contain following values:")
    public void userTableAssert(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists(String.class);
        List<List<String>> tableWithoutHeader = new ArrayList<>(expectedTable);
        tableWithoutHeader.remove(0);
        assertThat(userTablePage.getUserTable()).isEqualTo(tableWithoutHeader);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void userRolesAssert(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists(String.class);
        List<List<String>> tableWithoutHeader = new ArrayList<>(expectedTable);
        tableWithoutHeader.remove(0);
        List<String> res = new ArrayList<>();
        tableWithoutHeader.forEach(res::addAll);
        assertThat(userTablePage.getUserRoles()).isEqualTo(res);
    }
}
