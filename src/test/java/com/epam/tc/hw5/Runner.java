package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"pretty"},
    features = "classpath:com/epam/tc/hw5"
)

public class Runner extends AbstractTestNGCucumberTests {
}
