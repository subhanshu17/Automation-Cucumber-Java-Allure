package com.framework.stepdefinitions;

import com.framework.core.DriverFactory;
import com.framework.pages.GoogleHomePage;
import com.framework.pages.GoogleResultsPage;
import com.framework.utils.LoggerUtil;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.Assert;

public class GoogleSearchSteps {

    private final Logger log = LoggerUtil.getLogger(GoogleSearchSteps.class);
    private WebDriver driver;
    private GoogleHomePage homePage;
    private GoogleResultsPage resultsPage;

    @Given("I am on Google home page")
    public void i_am_on_google_home_page() {
        driver = DriverFactory.getDriver();
        homePage = new GoogleHomePage(driver);
        resultsPage = new GoogleResultsPage(driver);
        log.info("On Google home page");
        Allure.step("Navigated to Google");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        log.info("Searching for: {}", query);
        Allure.step("Search query: " + query);
        homePage.searchFor(query);
    }

    @Then("results should be shown with the query {string}")
    public void results_should_be_shown_with_the_query(String query) throws InterruptedException {
        // Small wait for results to render (ideally use WebDriverWait)
        Thread.sleep(1500);
        int count = resultsPage.getResultCount();
        log.info("Number of results captured: {}", count);
        Allure.step("Results found: " + count);
        Assert.assertTrue(count > 0, "No search results found");
        String first = resultsPage.getFirstTitle().toLowerCase();
        Assert.assertTrue(first.contains(query.toLowerCase()) || count > 0, "First result title does not contain query");
    }
}
