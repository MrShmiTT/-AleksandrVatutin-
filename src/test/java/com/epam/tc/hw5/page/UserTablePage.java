package com.epam.tc.hw5.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage extends AbstractPage {

    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

    @FindBy(linkText = "USER TABLE")
    private WebElement userTableButton;

    @FindBy(css = "td select")
    private List<WebElement> dropDown;

    @FindBy(css = "td a")
    private List<WebElement> userName;

    @FindBy(css = "div.user-descr span")
    private List<WebElement> description;

    @FindBy(css = "div.user-descr label")
    private List<WebElement> checkBoxes;

    @FindBy(css = "tbody tr")
    private List<WebElement> dataRow;

    @FindBy(xpath = "//tr[1]/td[2]/select/option")
    private List<WebElement> userRoles;

    @FindBy(id = "ivan")
    private WebElement checkboxIvan;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    List<WebElement> logsUserTable;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnServiceButton() {
        differentElementsPage.getServiceButton().click();
    }

    public void clickOnUserTableButton() {
        userTableButton.click();
    }

    public int countDropdownsNumber() {
        return dropDown.size();
    }

    public int countUsersNumber() {
        return userName.size();
    }

    public int countDescriptionsNumber() {
        return description.size();
    }

    public int countCheckBoxesNumber() {
        return checkBoxes.size();
    }

    public List<List<String>> getUserTable() {
        List<List<String>> info = new ArrayList<>();
        for (WebElement row : dataRow) {
            List<String> innerList = new ArrayList<>();
            String number = row.findElement(By.tagName("td")).getText();
            String name = row.findElement(By.cssSelector("td a")).getText();
            String description = row.findElement(By.cssSelector("div.user-descr span"))
                                    .getText()
                                    .replaceAll("\n", " ");
            Collections.addAll(innerList, number, name, description);
            info.add(innerList);
        }
        return info;
    }

    public List<String> getUserRoles() {
        return userRoles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnCheckBoxIvan() {
        checkboxIvan.click();
    }

    public List<String> getLogsUserTable() {
        return logsUserTable.stream().map(e -> e.getText().substring(e.getText().indexOf(' ') + 1))
                   .collect(Collectors.toList());
    }
}
