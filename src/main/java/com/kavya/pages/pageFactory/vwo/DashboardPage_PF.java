package com.kavya.pages.pageFactory.vwo;

import com.kavya.base.CommonToAllPage;
import com.kavya.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_PF extends CommonToAllPage {

    WebDriver driver;
    public DashboardPage_PF(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //private By userNameDashBoard = By.xpath("//h6");
    @FindBy(xpath = "//h6")
    private By userNameDashBoard;

    public String loggedInUsername(){

        WaitHelpers.waitJVM(5000);
        openVWODashBoardUrl();
        String username= getText(userNameDashBoard);
        return username;

//        WaitHelpers.visibilityOfElement(userNameDashBoard);
//        return getText(userNameDashBoard);

    }
}
