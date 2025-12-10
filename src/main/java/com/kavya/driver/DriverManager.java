package com.kavya.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver driver;

    // getter and setter
    public static WebDriver getDriver() {
        return driver;
    }
    public static void setDriver(WebDriver driver){
        DriverManager.driver= driver;
    }



}
