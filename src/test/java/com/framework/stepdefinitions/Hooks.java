package com.framework.stepdefinitions;

import com.framework.core.DriverFactory;
import com.framework.utils.ConfigReader;
import com.framework.utils.LoggerUtil;
import com.framework.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class Hooks {
    private static final Logger log = LoggerUtil.getLogger(Hooks.class);

    @Before
    public void setUp() {
        log.info("Initializing WebDriver");
        DriverFactory.initDriver();
        WebDriver driver = DriverFactory.getDriver();
        String baseUrl = ConfigReader.get("baseUrl");
        log.info("Navigating to {}", baseUrl);
        driver.get(baseUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Scenario failed: {}", scenario.getName());
            ScreenshotUtil.attachScreenshot("Failure - " + scenario.getName());
        }
        log.info("Quitting WebDriver");
        DriverFactory.quitDriver();
    }
}
