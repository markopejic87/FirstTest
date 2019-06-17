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
        //asserts that we moved to the login page
        Assert.assertEquals(testServerUrl+loginPage.getLoginUrlPath(),driver.getCurrentUrl() );
    }

    @Test
    public void login_success(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        loginPage.enterUsername("marko.test.345@gmail.com");
        loginPage.enterPassword("Test1234!");
        loginPage.clickOnLoginAndLogin();
    }

    @Test
    public void login_incorrect_password(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        loginPage.enterUsername("marko.test.345@gmail.com");
        loginPage.enterPassword("incorrectpass!");
        loginPage.clickOnLogin();
        String errorMessage = driver.findElement(loginPage.getLoginErrorTextSelector()).getText();
        Assert.assertEquals(errorMessage, "Email adresa ili lozinka nisu validni." );
    }

    @Test
    public void login_empty_form(){
        driver.get(testServerUrl+loginPage.getLoginUrlPath());
        loginPage.clickOnLogin();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getValidationRequiredTextId()));
        Assert.assertEquals("Ovo je obavezno polje.",errorMessage.getText());
    }
}
