package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends WebPage{

    protected String cartTableId="shopping-cart-table";
    protected String removeNthElementFromCart="#shopping-cart-table > tbody > tr > td.a-center.product-cart-actions.last > a:nth-child(EL)";
    protected String emptyCartMessageSelector = "#mm-0 > div > div.main-container.col1-layout > div > div > div.col-main > div.page-title.cart-empty-title > h1";
    protected String checkoutButtonSelector = "#mm-0 > div > div.main-container.col1-layout > div > div > div.col-main > div.cart > div.cart-collaterals > div > div.totals > ul > li > button";


    public CheckoutPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getCartTableId() {
        return By.id(cartTableId);
    }

    public By getRemoveNthElement(Integer i) {
        return By.cssSelector(removeNthElementFromCart.replace("EL", i.toString()));    }

    public void removeNthproduct(Integer i){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getRemoveNthElement(i)));
        c.click();

    }

    public By getEmptyCartMessageSelector() {
        return By.cssSelector(emptyCartMessageSelector);
    }

    public String getEmptyCartMessage(){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(getEmptyCartMessageSelector()));
        return e.getText();
    }

    public By getCheckoutButtonSelector() {
        return By.cssSelector(checkoutButtonSelector);
    }

    public void clickOnCheckoutButton(){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckoutButtonSelector()));
        e.click();


    }
}
