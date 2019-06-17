package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends WebPage {

    protected String myAccountWrapperSelector ="#mm-0 > div > div.main-container.col1-layout > div > div > div > div.my-account";
    protected String finishShoppingTextSelector = "#opc-login-content > div.col1-set > div > h3";



    public ConfirmationPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getMyAccountWrapperSelector() {
        return By.cssSelector(myAccountWrapperSelector);
    }

    public By getFinishShoppingTextSelector() {
        return By.cssSelector(finishShoppingTextSelector);
    }

    //gets the text that is displayed when you confirm the shopping
    public String getFinishShoppingText(){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(getFinishShoppingTextSelector()));
        return e.getText();
    }
}