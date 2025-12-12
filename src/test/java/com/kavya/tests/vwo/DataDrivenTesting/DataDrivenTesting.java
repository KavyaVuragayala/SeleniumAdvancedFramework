package com.kavya.tests.vwo.DataDrivenTesting;

import com.kavya.base.CommonToAllTest;
import com.kavya.driver.DriverManager;
import com.kavya.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.kavya.utils.PropertiesReader;
import com.kavya.utilsExcel.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DataDrivenTesting extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(DataDrivenTesting.class);
    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password){

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email, password);

        assertThat(error_msg).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }


    @DataProvider
    public Object[][] getData(){

        return UtilExcel.getTestDataFromExcel("sheet1");

    }
}
