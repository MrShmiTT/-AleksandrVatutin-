package com.epam.tc.hw5.page;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(linkText = "SERVICE")
    private WebElement serviceButton;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsButton;

    @FindBy(xpath = "//label[@class='label-checkbox'][1]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class='label-checkbox'][3]")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[@class='label-radio'][4]")
    private WebElement radioSelen;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdownList;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowColor;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Go to Different Elements page")
    public void goToDifferentElementsPage() {
        serviceButton.click();
        differentElementsButton.click();
    }

    @Step("Get page title")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Select Water checkbox")
    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    @Step("Select Wind checkbox")
    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    @Step("Select Selen radio")
    public void selectRadioSelen() {
        radioSelen.click();
    }

    @Step("Select dropdown list")
    public void selectDropDownList() {
        dropdownList.click();
    }

    @Step("Select Yellow in dropdown list")
    public void selectYellowInDropDownList() {
        yellowColor.click();
    }

    @Step("Get logs")
    public List<String> getLogs() {
        return logs.stream().map(e -> e.getText().substring(e.getText().indexOf(' ') + 1))
                   .collect(Collectors.toList());
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }
}
