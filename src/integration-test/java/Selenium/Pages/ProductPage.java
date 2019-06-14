package Selenium.Pages;


import Selenium.BaseSeleniumClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends WebPage {

    protected String addToCartButtonId = "product-addtocart-button";
    protected String checkoutURL= BaseSeleniumClass.URL+"/checkout/cart/";
    protected String productViewSelector="#mm-0 > div > div.main-container.col1-layout > div > div.main > div > div.product-view";


    public ProductPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getAddToCartButtonId() {
        return By.id(addToCartButtonId);
    }

    public void clickAddToCart(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getAddToCartButtonId()));
        c.click();
    }

    public By getProductViewSelector() {
        return By.cssSelector(productViewSelector);
    }

    public String getCheckoutURL() {
        return checkoutURL;
    }
}
