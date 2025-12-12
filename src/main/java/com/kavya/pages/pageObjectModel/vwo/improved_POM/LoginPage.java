package com.kavya.pages.pageObjectModel.vwo.improved_POM;

import com.kavya.base.CommonToAllPage;
import com.kavya.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {
    //Driver
    //Page Class
    //Page Locators
    //Page Actions

    WebDriver driver;
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public void loginToVWOLoginValidCreds(String user,String pwd){

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        WaitHelpers.waitJVM(5000);

    }

    public String loginToVWOLoginInvalidCreds(String user,String pwd){

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        WaitHelpers.waitJVM(5000);
        String error_msg = getText(error_message);
        //WaitHelpers.checkVisibility(getDriver(),error_message);
        //return getText(error_message);
        return error_msg;
    }
}
