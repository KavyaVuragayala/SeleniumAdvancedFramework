package com.kavya.pages.pageObjectModel.vwo;

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
        driver.get("https://app.vwo.com/#/dashboard");
        return driver.findElement(userNameDashBoard).getText();
    }

}

