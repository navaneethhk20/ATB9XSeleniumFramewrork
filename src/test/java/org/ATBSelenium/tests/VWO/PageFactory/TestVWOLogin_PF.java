package org.ATBSelenium.tests.VWO.PageFactory;


import org.ATBSelenium.Pages.PageFactory.LoginPage_PF;
import org.ATBSelenium.driver.DriverManager;
import org.ATBSelenium.base.CommonToAllTest;
import org.ATBSelenium.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVWOLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        String error_msg = loginPagePf.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }
}
