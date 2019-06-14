package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends WebPage {

    protected String checkoutWrapperId ="checkout-progress-wrapper";
    protected String finishShoppingTextSelector = "#opc-login-content > div.col1-set > div > h3";



    public ConfirmationPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getCheckoutWrapperId() {
        return By.id(checkoutWrapperId);
    }

    public By getFinishShoppingTextSelector() {
        return By.cssSelector(finishShoppingTextSelector);
    }

    public String getFinishShoppingText(){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(getFinishShoppingTextSelector()));
        return e.getText();
    }
}