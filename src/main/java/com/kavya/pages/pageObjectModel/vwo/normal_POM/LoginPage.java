package com.kavya.pages.pageObjectModel.vwo.normal_POM;
import com.kavya.utils.PropertiesReader;
import com.kavya.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // This is a Page Class

    WebDriver driver;

    // Step 0 : Parameterized Constructor
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }


    // Step 1 : Page Locators [ declaring in private because encapsulation as we have to hide locators ]
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    //if not using any locator don't add them here


    // Step 2 : Page Actions - [ functionalities ]
    public void loginToVWOLoginValidCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
        //driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.waitJVM(5000);

    }

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver,error_message);
        String error_message_text = driver.findElement(error_message).getText();

        return error_message_text;
    }


}
