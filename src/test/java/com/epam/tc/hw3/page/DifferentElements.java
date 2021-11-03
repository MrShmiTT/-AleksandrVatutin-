package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElements extends AbstractPage {

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

    public DifferentElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void goToDifferentElementsPage() {
        serviceButton.click();
        differentElementsButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void selectConfig() {
        waterCheckbox.click();
        windCheckbox.click();
        radioSelen.click();
        dropdownList.click();
        yellowColor.click();
    }

    public List<String> getLogs() {
        return logs.stream().map(e -> e.getText().substring(e.getText().indexOf(' ') + 1))
                   .collect(Collectors.toList());
    }
}
