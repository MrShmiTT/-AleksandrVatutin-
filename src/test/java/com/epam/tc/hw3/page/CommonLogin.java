package com.epam.tc.hw3.page;

import com.epam.tc.hw3.config.ConfProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonLogin extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement loginIcon;

    @FindBy(id = "name")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "user-name")
    private WebElement fullUserName;

    public CommonLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void login() {
        loginIcon.click();
        inputLogin.sendKeys(ConfProperties.getProperty("login"));
        inputPassword.sendKeys(ConfProperties.getProperty("password") + Keys.ENTER);
    }

    public String getFullUserName() {
        return fullUserName.getText();
    }
}
