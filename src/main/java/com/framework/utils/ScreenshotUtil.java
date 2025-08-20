package com.framework.utils;

import com.framework.core.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtil {
    public static void attachScreenshot(String name) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver instanceof TakesScreenshot) {
            byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(src));
        }
    }
}
