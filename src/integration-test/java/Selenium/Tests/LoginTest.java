package Selenium.Tests;

import Selenium.BaseSeleniumClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends BaseSeleniumClass {



    //Tests to see if you can get to a login page from the homepage
    @Test
    public void login_from_homepage(){
        driver.get(testServerUrl);
        homePage.hoverAndClickOnMyAccount();
        Assert.assertEquals(testServerUrl+loginPage.getLoginUrlPath(),driver.getCurrentUrl() );
    }

    @Test
    public void login_success(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        WebElement usernameForm = driver.findElement(loginPage.getUsernameId());
        usernameForm.sendKeys("marko.test.345@gmail.com");
        //usernameForm.sendKeys(credentials.getProperty("username"));

        WebElement passwordForm = driver.findElement(loginPage.getPasswordId());
        passwordForm.sendKeys("Test1234!");
       // passwordForm.sendKeys("password");

        loginPage.clickOnLoginAndLogin();
        //Assert.assertEquals(URL, "https://www.youtube.com/" );
    }

    @Test
    public void login_incorrect_password(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        WebElement usernameForm = driver.findElement(loginPage.getUsernameId());
        usernameForm.sendKeys("marko.test.345@gmail.com");
        //usernameForm.sendKeys(credentials.getProperty("username"));

        WebElement passwordForm = driver.findElement(loginPage.getPasswordId());
        passwordForm.sendKeys("wrongpassword");
        // passwordForm.sendKeys("password");

        loginPage.clickOnLogin();
        String errorMessage = driver.findElement(loginPage.getLoginErrorTextSelector()).getText();
        Assert.assertEquals(errorMessage, "Email adresa ili lozinka nisu validni." );
    }

    @Test
    public void login_empty_form(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        loginPage.clickOnLogin();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getShortUsernameTextId()));
        //to do assert error message
    }
}
