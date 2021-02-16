package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithDifferentUser_StepDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String string) {
       wait.until(ExpectedConditions.visibilityOf(dashboardPage.userIDName));
       String userName = dashboardPage.userIDName.getAttribute("innerHTML");
        Assert.assertEquals(string,userName);



    }

}
