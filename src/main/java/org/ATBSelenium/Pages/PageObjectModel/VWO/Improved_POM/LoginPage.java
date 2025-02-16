package org.ATBSelenium.Pages.PageObjectModel.VWO.Improved_POM;

import org.ATBSelenium.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {
    WebDriver driver;



    // Page Class
    // Page Locators

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }




    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By singBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");


    // Step 2 - Page Actions

    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        presenceOfElement(error_message);
        return getText(error_message);

    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
//        custom_wait();

    }




}
