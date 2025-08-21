package com.framework.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;

import com.framework.core.DriverFactory;
import com.framework.utils.ConfigReader;
import com.framework.utils.LoggerUtil;
import com.framework.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static final Logger log = LoggerUtil.getLogger(Hooks.class);
    
    @BeforeSuite()
    public void start() {
    	log.info("==============Test Sui");
    }

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
        
//        generateAllureReport();
    }

//    public void generateAllureReport(){
//		
//        try {
//        	ProcessBuilder builder = new ProcessBuilder("E:\\allure-2.34.1\\allure-2.34.1\\bin\\allure","generate","--single-file target/allure-results --clean");
//        	builder.inheritIO();
//        	Process process=builder.start();
////            String command = "allure generate target/allure-results -o target/allure-report --clean";
////            Process process = Runtime.getRuntime().exec(command);
//            process.waitFor();
//            System.out.println("✅ Allure Report generated at: target/allure-report/index.html");
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("⚠️ Failed to generate Allure Report automatically.");
//        }
//    }
}
