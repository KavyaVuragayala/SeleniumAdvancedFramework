package com.kavya.driver;

import com.kavya.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver; //shared btw test cases

    // getter and setter
    public static WebDriver getDriver() {

        return driver;
    }
    public static void setDriver(WebDriver driver){

        DriverManager.driver= driver;
    }

    //starting a browser
    public static void init(){
        // get the value from properties reader
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch(browser){
            case "edge " :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                System.out.println("Browser Not Supported !!!!!!");

        }


    }

    // closing the browser
    public static void down(){

        if(getDriver()!=null){
            driver.quit();
        }
    }


}
