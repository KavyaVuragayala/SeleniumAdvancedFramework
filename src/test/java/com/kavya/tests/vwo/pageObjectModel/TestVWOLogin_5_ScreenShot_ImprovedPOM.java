package com.kavya.tests.vwo.pageObjectModel;

import com.kavya.listeners.RetryAnalyzer;
import com.kavya.listeners.ScreenShotListener;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static com.kavya.driver.DriverManager.getDriver;

@Listeners(ScreenShotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_5_ScreenShot_ImprovedPOM {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_5_ScreenShot_ImprovedPOM.class);


    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
//        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }

    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }
}
