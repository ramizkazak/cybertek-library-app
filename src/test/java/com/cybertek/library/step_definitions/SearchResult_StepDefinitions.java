package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResult_StepDefinitions {
    UsersPage usersPage = new UsersPage();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        List<String> webElements = new ArrayList<>();
        for (WebElement eachElementText : usersPage.columnNames)
            webElements.add(eachElementText.getText());
        Assert.assertEquals(expectedColumnNames, webElements);
    }
}
