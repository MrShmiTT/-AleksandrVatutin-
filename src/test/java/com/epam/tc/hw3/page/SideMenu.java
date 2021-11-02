package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li")
    List<WebElement> sideButtons;

    public SideMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean areSideButtonsDisplayed() {
        for (WebElement sideButton : sideButtons) {
            if (!sideButton.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getSideButtons() {
        return sideButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
