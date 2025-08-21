package com.framework.utils;

import org.testng.annotations.AfterSuite;

import java.io.IOException;

public class ReportGenerator {

    @AfterSuite
    public void generateAllureReport() {
//        try {
//            String command = "allure generate target/allure-results -o target/allure-report --clean";
//            Process process = Runtime.getRuntime().exec(command);
//            process.waitFor();
//            System.out.println("✅ Allure Report generated at: target/allure-report/index.html");
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("⚠️ Failed to generate Allure Report automatically.");
//        }
    }
}
