package Selenium.Tests;

import Selenium.BaseSeleniumClass;
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
        searchField.sendKeys("youtube");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(pageTest.getsearchButtonId()));
        searchButton.click();
        WebElement firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTest.gettoptalId()));
        firstLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTest.getsideBarIdButtonId()));
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        Assert.assertEquals(URL, "https://www.youtube.com/" );
    }
}
