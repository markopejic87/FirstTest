package Selenium.Pages;

import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends WebPage{


    protected String searchBoxId ="search";
    protected String searchButtonSelector ="#search_mini_form > div > button > span";
    protected String myAccountSelector = "#mm-0 >  div li.action-button.account-button";
    protected String signInButtonSelector = "#mm-0 >  div li.action-button.account-button > ul > li > ul > li.first > a";
    protected String nthElementInList = "#products-list > li:nth-child(EL) > div.right-cols > div.col23top > h2 > a";
    protected String productListId="products-list";
    protected String labelByTextXpath="//label[text()[contains(.,'NAME')]]";
    protected String tvSubDivisionSelector = "#nav > ol > li.level0.nav-1.first.parent > a > span:nth-child(2)";
    protected String tvSelector = "#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.nav-1-1.first.parent > ul > li.level2.nav-1-1-1.first > a";
    protected String manufacturorExpandSelector = "#narrow-by-list > dt:nth-child(5)";
    protected String screenTypeExpandSelector = "#narrow-by-list > dt:nth-child(15)";
    protected String screenSizeExpandSelector = "#narrow-by-list > dt:nth-child(13)";



    public HomePage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getSearchBox() {
        return By.id(searchBoxId);
    }
    public By getsearchButtonSelector() {
        return By.cssSelector(searchButtonSelector);
    }

    public By getMyAccountSelector() {
        return By.cssSelector(myAccountSelector);
    }

    public By getSignInButtonSelector() {
        return By.cssSelector(signInButtonSelector);
    }

    public void hoverAndClickOnMyAccount(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(getMyAccountSelector());
        action.moveToElement(we).moveToElement(driver.findElement(getSignInButtonSelector())).click().build().perform();
    }

    public void enterTextInSearch(String s) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(getSearchBox()));
        searchBox.sendKeys(s);
    }

    public By getNthElementInList(Integer i) {
        return By.cssSelector(nthElementInList.replace("EL", i.toString()));    }

    public By getProductListId() {
        return By.id(productListId);
    }

    public void clickOnSearch(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getsearchButtonSelector()));
        c.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProductListId()));
    }

    public void clickOnNthProduct(Integer i){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getNthElementInList(i)));
        c.click();
    }

    public By getLabelByXpath(String s) {
        return By.xpath(labelByTextXpath.replace("NAME", s));
    }

    //
    public void checkFilter(String s){
        //s = WordUtils.capitalizeFully(s, ' ');
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getLabelByXpath(s)));
        c.click();
    }

    public void hoverAndClickTV(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector("#menu > ul > li.menu-item.catalog > dl > dt > h2"));
        action.moveToElement(we).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector(tvSubDivisionSelector))).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector(tvSelector))).click().build().perform();
    }

    public void clickOnManufacturor(){

        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(manufacturorExpandSelector)));
        c.click();

    }

    public void clickOnScreenType(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(screenTypeExpandSelector)));
        c.click();
    }

    public void clickOnScreenSize(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(screenSizeExpandSelector)));
        c.click();
    }

}
