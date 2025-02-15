package org.ATBSelenium.tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.DashBoardPage;
import org.ATBSelenium.Pages.PageObjectModel.VWO.Normal.LoginPage;
import org.ATBSelenium.base.CommonToAllTest;
import org.ATBSelenium.driver.DriverManager;
import org.ATBSelenium.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VWO_Improved_POM_PropertiesReaderTestCase extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(VWO_Improved_POM_PropertiesReaderTestCase.class);

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        logger.info("Starting the Testcases Page Object Model");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


        logger.info("End of the testLoginNegativeVWO !");

        // Assertion AssertJ
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();

        // Assertion TestNG
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));


    }

    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }
}
