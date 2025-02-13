package org.ATBSelenium.Pages.PageObjectModel.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By Signbutton = By.id("js-login-btn");
    private By error_messege = By.id("js-notification-box-messege");

    public static loginToVWOLoginInvalidCreds(String user, String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(passwprd).sendKeys(pwd);
        driver.findElement(signButton).click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_messege_text = driver.findElement(error_messege).getText();
        return error_messege_text;
    }

    public static loginToVWOLoginValidCreds(String user, String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(passwprd).sendKeys(pwd);
        driver.findElement(signButton).click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





}
