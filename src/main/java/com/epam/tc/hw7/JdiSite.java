package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.MetalsAndColorsPage;
import org.checkerframework.checker.guieffect.qual.UI;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static String getUserName() {
        return homePage.getUserName();
    }


}
