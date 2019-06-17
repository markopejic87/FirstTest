package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends WebPage {

    protected String usernameId ="email";
    protected String passwordId ="pass";
    protected String loginButtonId ="send2";
    ConfirmationPage loginConfirmationPage= new ConfirmationPage(wait,driver);
    protected String loginErrorTextSelector="#mm-0 > div.wrapper > div > div.main-container.col1-layout > div > div > div > div > ul > li > ul > li > span";
    protected String loginUrlPath= "/customer/account/login/";
    protected String validationRequiredTextId="advice-required-entry-email";

    public LoginPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getUsernameId() {
        return By.id(usernameId);
    }

    public By getPasswordId() {
        return By.id(passwordId);
    }

    public By getLoginButtonId() {
        return By.id(loginButtonId);
    }

    public void clickOnLogin(){
        WebElement loginButton= driver.findElement(By.id(loginButtonId));
        loginButton.click();
    }

    //combined action of clicking on login andverifying thah the user is logged in
    public void clickOnLoginAndLogin(){
        clickOnLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginConfirmationPage.getMyAccountWrapperSelector()));
    }

    public By getLoginErrorTextSelector() {
        return By.cssSelector(loginErrorTextSelector);
    }

    public String getLoginUrlPath() {
        return loginUrlPath;
    }

    //enter username in a given form
    public void enterUsername(String s){
        WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(getUsernameId()));
        usernameForm.sendKeys(s);
    }
    //enter password in a given form
    public void enterPassword(String s){
        WebElement passwordForm = wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordId()));
        passwordForm.sendKeys(s);
    }

    public By getValidationRequiredTextId() {
        return By.id(validationRequiredTextId);
    }
}
