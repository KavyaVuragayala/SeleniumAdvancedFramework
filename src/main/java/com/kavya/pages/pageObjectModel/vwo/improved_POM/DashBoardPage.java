package com.kavya.pages.pageObjectModel.vwo.improved_POM;

import com.kavya.base.CommonToAllPage;
import com.kavya.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends CommonToAllPage {

    WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameDashBoard = By.xpath("//h6");

    public String loggedInUsername(){

        WaitHelpers.waitJVM(5000);
        openVWODashBoardUrl();
        String username= getText(userNameDashBoard);
        return username;

//        WaitHelpers.visibilityOfElement(userNameDashBoard);
//        return getText(userNameDashBoard);

    }
}
