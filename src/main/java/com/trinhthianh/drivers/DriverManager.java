package com.trinhthianh.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    public static WebDriver getDriver() { // Thay đổi kiểu trả về từ AppiumDriver sang WebDriver
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver) {
        DriverManager.driver.set(driver);
    }


    public static void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }



    private static ThreadLocal<List<AppiumDriver<MobileElement>>> drivers = new ThreadLocal<>();

    public static void setDrivers(List<AppiumDriver<MobileElement>> driverList) {
        drivers.set(driverList);
    }

    public static List<AppiumDriver<MobileElement>> getDrivers() {
        return drivers.get();
    }

    public static void quit(AppiumDriver<MobileElement> driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
