package Selenium.Tests;

import Selenium.BaseSeleniumClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchProductTest extends BaseSeleniumClass {

    @Test
    public void search_product_by_three_criteria(){
        String filter1= "LED";
        String filter2= "Philips";
        String filter3= "32\"";

        driver.get(testServerUrl);
        homePage.hoverAndClickTV();
        homePage.checkFilter(filter1);
        homePage.clickOnManufacturor();
        homePage.checkFilter(filter2);
        homePage.clickOnScreenSize();
        homePage.checkFilter(filter3);
        WebElement productsList = driver.findElement(By.id("products-list"));
        List<WebElement> products = productsList.findElements(By.tagName("h2"));
        for (int j = 0; j < products.size(); j++){
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter1.toLowerCase()));
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter2.toLowerCase()));
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter3.toLowerCase()));
        }
    }


}
