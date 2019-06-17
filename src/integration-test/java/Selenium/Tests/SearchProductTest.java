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
        homePage.clickOnScreenType();
        homePage.checkFilterCheckbox(filter1);
        homePage.clickOnManufacturer();
        homePage.checkFilterCheckbox(filter2);
        homePage.clickOnScreenSize();
        homePage.checkFilterCheckbox(filter3);
        List<WebElement> products = homePage.getProductList();
        for (int j = 0; j < products.size(); j++){
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter1.toLowerCase()));
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter2.toLowerCase()));
            Assert.assertTrue(products.get(j).getText().toLowerCase().contains(filter3.toLowerCase()));
        }
    }


}
