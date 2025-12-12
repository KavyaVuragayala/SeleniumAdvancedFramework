package com.kavya.base;

import com.kavya.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Properties;

import static com.kavya.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void openVWODashBoardUrl(){
        getDriver().get(PropertiesReader.readKey("url_dashboard"));
    }

    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }
}
