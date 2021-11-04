package com.epam.tc.hw4.page;

import com.epam.tc.hw4.config.ConfProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement loginIcon;

    @FindBy(id = "name")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "user-name")
    private WebElement fullUserName;

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open URL - {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Get page title")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Perform login {login}")
    public void login() {
        loginIcon.click();
        inputLogin.sendKeys(ConfProperties.getProperty("login"));
        inputPassword.sendKeys(ConfProperties.getProperty("password") + Keys.ENTER);
    }

    @Step("Get full user name")
    public String getFullUserName() {
        return fullUserName.getText();
    }
}
