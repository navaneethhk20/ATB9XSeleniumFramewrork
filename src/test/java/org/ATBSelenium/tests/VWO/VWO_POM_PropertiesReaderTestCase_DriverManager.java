package org.ATBSelenium.tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.DashBoardPage;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.LoginPage;

import org.ATBSelenium.base.CommonToAllTest;
import org.ATBSelenium.driver.DriverManager;
import org.ATBSelenium.utils.PropertiesReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VWO_POM_PropertiesReaderTestCase_DriverManager extends CommonToAllTest {
    @Owner("Navaneeth")
    @Description("Verify Negative test case")
    @Test
    public void testLoginNegativeVWO(){

        LoginPage loginPageVWO = new LoginPage(DriverManager.getDriver());
        String error_messege = loginPageVWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(error_messege).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_messege, PropertiesReader.readKey("error_message"));
    }
    @Owner("Navaneeth")
    @Description("Verify Positive test case")
    @Test
    public void testLoginPositiveVWO(){


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));


        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
