package org.ATBSelenium.tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.DashBoardPage;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.LoginPage;
import org.ATBSelenium.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VWO_POM_PropertiesReaderTestCase {
    @Owner("Navaneeth")
    @Description("Verify Negative test case")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPageVWO = new LoginPage(driver);
        String error_messege = loginPageVWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(error_messege).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_messege, PropertiesReader.readKey("error_message"));
    }
    @Owner("Navaneeth")
    @Description("Verify Positive test case")
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPageVWO = new LoginPage(driver);
        String error_messege = loginPageVWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
