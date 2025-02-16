package org.ATBSelenium.Pages.PageFactory;

import org.ATBSelenium.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_PF extends CommonToAllPage {
    WebDriver driver;

    public void DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
