package Selenium;

import Selenium.Pages.PageTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestSelenium extends BaseSeleniumClass {

    public PageTest pageTest = new PageTest(wait,driver);


    @Test
    public void test2(){
        driver.get("https://duckduckgo.com");
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(pageTest.getLinkSelector()));
        searchField.sendKeys("b92");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(pageTest.getsearchButtonId()));
        searchButton.click();
        WebElement b92Link = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTest.gettoptalId()));
        b92Link.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTest.gettoptalButtonId()));
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        Assert.assertEquals(URL, "https://www.b92.net/" );
    }
}
