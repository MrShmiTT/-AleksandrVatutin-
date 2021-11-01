package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenu extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li")
    List<WebElement> sideButtons;

    protected SideMenu(WebDriver driver) {
        super(driver);
    }
}
