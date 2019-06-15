package Selenium.Tests;

import Selenium.BaseSeleniumClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutTest extends BaseSeleniumClass {

    @Test
    public void checkout_one_product_as_guest(){
        driver.get(testServerUrl);
        homePage.enterTextInSearch("tv");
        homePage.clickOnSearch();
        homePage.clickOnNthProduct(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.getProductViewSelector()));
        productPage.clickAddToCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getCartTableId()));
        checkoutPage.clickOnCheckoutButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPage.getFinishShoppingTextSelector()));
        Assert.assertTrue(confirmationPage.getFinishShoppingText().contains("kupovinu kao Gost ili se"));
        }
}
