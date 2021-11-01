package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

    @FindBy(xpath = "//header/div/nav/ul[1]/li")
    private List<WebElement> headerButtons;

    @FindBy(xpath = "//div[@class='benefit-icon']")
    private List<WebElement> imgs;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> imgElements;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(css = "#frame-button")
    private WebElement frameBtn;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public boolean getHeaderButtons() {
        headerButtons.forEach(button -> button.isDisplayed());
        return true;
    }

    public List getHeaderButtonsText() {
        headerButtons.stream().map(WebElement::getText).collect(Collectors.toList());
        return headerButtons;
    }
}
