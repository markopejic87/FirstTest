package Selenium.Tests;

import Selenium.BaseSeleniumClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemoveProductTest extends BaseSeleniumClass {

    @Test
    public void remove_one_product_from_cart(){
        driver.get(testServerUrl);
        homePage.enterTextInSearch("tv");
        homePage.clickOnSearch();
        homePage.clickOnNthProduct(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.getProductViewSelector()));
        productPage.clickAddToCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getCartTableId()));
        checkoutPage.removeNthproduct(1);
        Assert.assertEquals("Korpa je prazna",checkoutPage.getEmptyCartMessage());
    }



}