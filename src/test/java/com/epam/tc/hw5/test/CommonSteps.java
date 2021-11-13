package com.epam.tc.hw5.test;

import io.cucumber.java.en.Given;

public class CommonSteps extends BaseTest {

    //1. Open test site by URL
    @Given("I open JDI GitHub site")
    public void openHomePage() {
        login.open(URL);
    }

    //2. Perform login
    @Given("I login as user 'Roman Iovlev'")
    public void performLogin() {
        login.login();
    }
}
