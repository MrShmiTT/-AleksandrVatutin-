package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class JdiMetalsAndColorsPage extends WebPage {

    @FindBy(linkText = "METALS & COLORS")
    public Button metalAndColorsButton;

    public void goToMetalsAndColorsPage() {
        metalAndColorsButton.click();
    }


}
