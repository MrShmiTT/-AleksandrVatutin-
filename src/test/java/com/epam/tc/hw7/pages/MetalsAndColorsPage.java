package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.data.MetalsAndColorsData;
import com.epam.tc.hw7.forms.MetalAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI(".logs li")
    public JList<UIElement> logsList;

    @UI(".results li")
    public JList<UIElement> resultsList;

    @UI(".form")
    public MetalAndColorsForm form;

    public static void checkResults(MetalsAndColorsPage metalsAndColorsPage, MetalsAndColorsData metalsAndColorsData) {
        List<String> results =
            metalsAndColorsPage.resultsList.stream().map(UIElement::getText).collect(Collectors.toList());
        Assert.assertEquals(results, metalsAndColorsData.expectedResultList());
    }

}
