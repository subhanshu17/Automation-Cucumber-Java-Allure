package com.framework.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {
    private final WebDriver driver;

    private final By resultTitles = By.cssSelector("div#search a h3");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getResultCount() {
        List<WebElement> results = driver.findElements(resultTitles);
        return results.size();
    }

    public String getFirstTitle() {
        List<WebElement> results = driver.findElements(resultTitles);
        return results.isEmpty() ? "" : results.get(0).getText();
    }
}
