package com.kavya.tests.vwo.pageObjectModel;

import com.kavya.base.CommonToAllTest;
import com.kavya.driver.DriverManager;
import com.kavya.pages.pageObjectModel.vwo.DashBoardPage;
import com.kavya.pages.pageObjectModel.vwo.LoginPage;
import com.kavya.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_Optimized extends CommonToAllTest {
    // step 1 : Driver                   D
    // step 2: Locators                  L
    // step 3 : Validation / Assertion   V

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_Optimized.class);

    @Description("TC #1 Verify that valid creds and dashboard page is loaded")
    @Test
    public void testLoginValidVWO(){

        System.out.println("Working dir: " + System.getProperty("user.dir"));

        logger.info("Starting of testcase Page Object Model");
        //Page Class Code(POM Code) - 2 L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUsername();

        logger.info("Asserting the valid credentials");
        //Assertions - 3 V
        assertThat(usernameLoggedIn).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }

    @Description("TC #2 Verify that invalid email,pass, error message is displayed")
    @Test
    public void testLoginInvalidVWO(){

        System.out.println("Working dir: " + System.getProperty("user.dir"));

        logger.info("Starting of testcase Page Object Model");
        LoginPage loginPage =new LoginPage(DriverManager.getDriver()); //2
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Asserting the invalid credentials");
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank(); //3
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));


    }
}
