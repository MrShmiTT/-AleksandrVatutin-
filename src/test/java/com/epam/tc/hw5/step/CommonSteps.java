package com.epam.tc.hw5.step;

import io.cucumber.java.en.Given;

public class CommonSteps extends BaseSteps {

    //1. Open test site by URL
    @Given("I open JDI GitHub site")
    public void openHomePage() {
        loginPage.open(URL);
    }

    //2. Perform login
    @Given("I login as user 'Roman Iovlev'")
    public void performLogin() {
        loginPage.login();
    }
}
