package com.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String query) {
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);
    }
}
