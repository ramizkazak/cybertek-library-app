package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ShowRecords_StepsDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch(link.toLowerCase()){
            case "dashboard":
                dashboardPage.dashboardPageLink.click();
                break;
            case "users":
                dashboardPage.usersPageLink.click();
                break;
            case "books":
                dashboardPage.booksPageLink.click();
                break;
        }

    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
       String expectedValue= int1.toString();
        Select select = new Select(usersPage.showRecordsDropDown);
        String actualValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {

        Select select = new Select(usersPage.showRecordsDropDown);
        List<WebElement> webElements = select.getOptions();
        List<String> dropDownList =new ArrayList<>();
        for(WebElement each : webElements){
            dropDownList.add(each.getText());
        }
        Assert.assertEquals(options,dropDownList);




        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }


}
