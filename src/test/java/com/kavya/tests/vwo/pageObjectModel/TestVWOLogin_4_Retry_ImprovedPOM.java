package com.kavya.tests.vwo.pageObjectModel;

import com.kavya.base.CommonToAllTest;
import com.kavya.driver.DriverManager;
import com.kavya.listeners.RetryAnalyzer;
import com.kavya.pages.pageObjectModel.vwo.improved_POM.DashBoardPage;
import com.kavya.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.kavya.utils.PropertiesReader;
import com.kavya.utils.TakeScreenShot;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.kavya.driver.DriverManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_4_Retry_ImprovedPOM extends CommonToAllTest {
    // step 1 : Driver                   D
    // step 2: Locators                  L
    // step 3 : Validation / Assertion   V

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_4_Retry_ImprovedPOM.class);


    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
//        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        new TakeScreenShot().takeScreenshot("testPass_1");
        Assert.assertTrue(true);
    }
}
