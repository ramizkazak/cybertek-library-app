package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.HomePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
      String actualLoginPageTitle = Driver.getDriver().getTitle();
      String expectedLoginPageTitle="Login - Library";
      Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
       loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("librarian13"));
        loginPage. password.sendKeys(ConfigurationReader.getProperty("password13"));
        loginPage.submitButton.click();
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("student30"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password30"));
        loginPage.submitButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        try {
            Assert.assertTrue(homePage.dashboardPageLink.isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println(homePage.rightNavigationBAr.getText()+" is not allow to see Dashboard PAge link. FAILED!!!");
        }

       homePage.rightNavigationBAr.click();
        homePage.logOutButton.click();
    }

    @When("I enter username {string}")
    public void iEnterUsername(String userName) {
        loginPage.inputEmail.sendKeys(userName);
    }

    @And("I enter password {string}")
    public void iEnterPasswordIFFPPf(String userPassword) {
        loginPage.password.sendKeys(userPassword);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.submitButton.click();
    }

    @When("there should be {string} users")
    public void there_should_be_users(String expectedNum) {
        wait.until(ExpectedConditions.visibilityOf(homePage.userCount));
        String actualNum = homePage.userCount.getText();
        Assert.assertEquals("FAiled!!!!",expectedNum,actualNum);
    }

    /* @Then("there should be {int} users")
        public void there_should_be_users(Integer int1) {
        int expectedUserNumber= int1;
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.userCount));
        String expected = String.valueOf(expectedUserNumber);
        String actualUserNumber =dashboardPage.userCount.getText();
        Assert.assertEquals("FAiled!!!!",expected,actualUserNumber);
        }
     */

    @When("I login using {string} and {string}")
    public void i_login_using_and(String userEmail, String userPassword) {
        loginPage.inputEmail.sendKeys(userEmail);
        loginPage.password.sendKeys(userPassword);
        loginPage.submitButton.click();
    }

}
