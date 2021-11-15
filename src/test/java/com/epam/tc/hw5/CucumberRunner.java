package com.epam.tc.hw5;

import com.epam.tc.hw5.util.Listener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
    plugin = {"pretty"},
    features = "classpath:com/epam/tc/hw5"
)
@Listeners(Listener.class)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
