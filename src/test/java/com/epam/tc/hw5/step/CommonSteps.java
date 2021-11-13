package com.epam.tc.hw5.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps extends BaseTest {

    //1. Open test site by URL
    @Given("I open JDI GitHub site")
    public void openHomePage() {
        login.open(URL);
    }

    //2. Perform login
    @And("I login as user 'Roman Iovlev'")
    public void performLogin() {
        login.login();
    }
}
