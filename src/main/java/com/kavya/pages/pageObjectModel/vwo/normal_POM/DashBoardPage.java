package com.kavya.pages.pageObjectModel.vwo.normal_POM;

import com.kavya.utils.PropertiesReader;
import com.kavya.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameDashBoard = By.xpath("//h6");

    public String loggedInUsername(){
        WaitHelpers.waitJVM(10000);
        driver.get(PropertiesReader.readKey("url_dashboard"));
        return driver.findElement(userNameDashBoard).getText();
    }

}

