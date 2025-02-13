package org.ATBSelenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.ATBSelenium.Pages.PageObjectModel.VWO.DashBoardPage;
import org.ATBSelenium.Pages.PageObjectModel.VWO.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VWOTestCase {
    @Owner("Navaneeth")
    @Description("Verify Negative test case")
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPageVWO = new LoginPage(driver);
        String error_messege = loginPageVWO.loginToVWOLoginInvalidCreds("admin@gmail.com", "123");

        assertThat(error_messege).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_messege, "Your email, password, IP address or location did not match");
    }
    @Owner("Navaneeth")
    @Description("Verify Positive test case")
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPageVWO = new LoginPage(driver);
        String error_messege = loginPageVWO.loginTOVWOLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");
    }
}
