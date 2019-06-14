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
    protected String shortUsernameTextId="advice-required-entry-email";

    protected String loginUrlPath= "/customer/account/login/";

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

    public void clickOnLoginAndLogin(){
        clickOnLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginConfirmationPage.getCheckoutWrapperId()));
    }

    public By getLoginErrorTextSelector() {
        return By.cssSelector(loginErrorTextSelector);
    }

    public By getShortUsernameTextId() {
        return By.id(shortUsernameTextId);
    }

    public String getLoginUrlPath() {
        return loginUrlPath;
    }


}
