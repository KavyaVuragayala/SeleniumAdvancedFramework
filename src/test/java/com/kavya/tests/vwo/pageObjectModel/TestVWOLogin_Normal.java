package com.kavya.tests.vwo.pageObjectModel;

import com.kavya.pages.pageObjectModel.vwo.DashBoardPage;
import com.kavya.pages.pageObjectModel.vwo.LoginPage;
import com.kavya.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_Normal {
    // step 1 : Driver                   D
    // step 2: Locators                  L
    // step 3 : Validation / Assertion   V


    @Description("TC #1 Verify that valid creds and dashboard page is loaded")
    @Test
    public void testLoginValidVWO(){
        //Driver Manager Code - 1 D
        WebDriver driver = new ChromeDriver();

        //Page Class Code(POM Code) - 2 L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUsername();

        //Assertions - 3 V
        assertThat(usernameLoggedIn).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

        driver.quit();


    }

    @Description("TC #2 Verify that invalid email,pass, error message is displayed")
    @Test
    public void testLoginInvalidVWO(){
        WebDriver driver = new ChromeDriver(); //1

        LoginPage loginPage =new LoginPage(driver); //2
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid-password"));

        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank(); //3
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

        driver.quit();
    }
}
