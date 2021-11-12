package com.epam.tc.hw5.page;

import com.epam.tc.hw5.config.ConfProperties;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//header/div/nav/ul[1]/li")
    List<WebElement> headerButtons;

    @FindBy(xpath = "//div[@class='benefit-icon']")
    private List<WebElement> imgs;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> imgElements;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(css = "#frame-button")
    private WebElement frameBtn;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li")
    List<WebElement> sideButtons;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Assert menu buttons are displayed")
    public boolean areHeaderButtonsDisplayed() {
        return headerButtons.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Assert menu buttons have proper names")
    public List<String> getHeaderButtonsText() {
        return headerButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Assert 4 images are displayed")
    public boolean areImagesDisplayed() {
        return imgs.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Assert images are displayed")
    public boolean areImageTextDisplayed() {
        return imgElements.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Assert images have proper texts")
    public List<String> getImageTexts() {
        return imgElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Assert frame is displayed")
    public boolean areFrameDisplayed() {
        return frame.isDisplayed();
    }

    @Step("Switch to frame")
    public void switchToFrame() {
        driver.switchTo().frame(ConfProperties.getProperty("frameName"));
    }

    @Step("Get frame button")
    public String getFrameButton() {
        return frameBtn.getAttribute(ConfProperties.getProperty("frameBtn"));
    }

    @Step("Switch to the parent frame")
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    @Step("Assert side buttons are displayed")
    public boolean areSideButtonsDisplayed() {
        return sideButtons.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Get side buttons")
    public List<String> getSideButtons() {
        return sideButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
