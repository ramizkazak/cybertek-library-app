package com.libraryCT.library.pages;

import com.libraryCT.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "navbarDropdown")
    public WebElement rightNavigationBAr;

    @FindBy(className = "dropdown-item")
    public WebElement logOutButton;

    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(linkText = "Users")
    public WebElement usersPageLink;

    @FindBy(linkText = "Books")
    public WebElement booksPageLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardPageLink;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userIDName;
}
