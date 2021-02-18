package com.libraryCT.library.step_definitions;

import com.libraryCT.library.pages.HomePage;
import com.libraryCT.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithDifferentUser_StepDefinitions {
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String string) {
       wait.until(ExpectedConditions.visibilityOf(homePage.userIDName));
       String userName = homePage.userIDName.getAttribute("innerHTML");
        Assert.assertEquals(string,userName);



    }

}
