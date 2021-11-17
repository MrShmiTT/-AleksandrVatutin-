package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.LoginForm;

public class JdiHomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(id = "user-name")
    public Label userName;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }
}
