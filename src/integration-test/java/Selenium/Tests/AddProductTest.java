package Selenium.Tests;

import Selenium.BaseSeleniumClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductTest extends BaseSeleniumClass {

    @Test
    public void add_one_product_to_the_cart(){
          driver.get(testServerUrl);
          homePage.enterTextInSearch("tv");
          homePage.clickOnSearch();
          homePage.clickOnNthProduct(1);
          wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.getProductViewSelector()));
          productPage.clickAddToCart();
          Assert.assertEquals(productPage.getCheckoutURL(),driver.getCurrentUrl() );
          //if the product is added to the cart cart table element exists
          wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getCartTableId()));
    }


}
