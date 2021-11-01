package com.epam.tc.hw3.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

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

//    @FindBy(xpath = "//header/div/nav/ul[1]/li")
    @FindBy(className = "uui-navigation")
    List<WebElement> headerButtons = new ArrayList<>();

    public boolean areHeaderButtonsDisplayed() {
        return headerButtons.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getHeaderButtonsText() {
        return headerButtons.stream().map(WebElement::getText)
                            .collect(Collectors.toList());
    }

//    @FindBy(className = "uui-navigation")
//    private WebElement headerMenu;
//
//    public String getHeaderMenuText() {
//        return headerMenu.getText();
//    }

    public boolean getImages() {
        for (WebElement img : imgs) {
            img.isDisplayed();
        }
        return true;
    }
}
