package com.epam.tc.hw4.page;

import com.epam.tc.hw4.config.ConfProperties;
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

    public boolean areHeaderButtonsDisplayed() {
        for (WebElement headerButton : headerButtons) {
            if (!headerButton.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getHeaderButtonsText() {
        return headerButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areImagesDisplayed() {
        for (WebElement img : imgs) {
            if (!img.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areImageTextDisplayed() {
        for (WebElement imgElement : imgElements) {
            if (!imgElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getImageTexts() {
        return imgElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areFrameDisplayed() {
        return frame.isDisplayed();
    }

    public void switchToFrame() {
        driver.switchTo().frame(ConfProperties.getProperty("frameName"));
    }

    public String getFrameButton() {
        return frameBtn.getAttribute(ConfProperties.getProperty("frameBtn"));
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
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
