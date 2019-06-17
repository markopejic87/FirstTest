package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
    protected String manufacturerExpandSelector = "#narrow-by-list > dt:nth-child(5)";
    protected String screenTypeExpandSelector = "#narrow-by-list > dt:nth-child(15)";
    protected String screenSizeExpandSelector = "#narrow-by-list > dt:nth-child(13)";
    protected String productsButtonSelector = "#menu > ul > li.menu-item.catalog > dl > dt > h2";



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

    //method that executes combined action of hovering on my account buton and clicking on sign in
    public void hoverAndClickOnMyAccount(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(getMyAccountSelector());
        action.moveToElement(we).moveToElement(driver.findElement(getSignInButtonSelector())).click().build().perform();
    }

    //enter given string in searchbox
    public void enterTextInSearch(String s) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(getSearchBox()));
        searchBox.sendKeys(s);
    }

    // get the n-th element from the product list that you get after the search
    public By getNthElementInList(Integer i) {
        return By.cssSelector(nthElementInList.replace("EL", i.toString()));    }

    public By getProductListId() {
        return By.id(productListId);
    }

    // clicks on a search button next to the search
    public void clickOnSearch(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getsearchButtonSelector()));
        c.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProductListId()));
    }

    //click on the n-th element from the product list that you get after the search
    public void clickOnNthProduct(Integer i){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getNthElementInList(i)));
        c.click();
    }

    //gets the label from the page that contains given string
    public By getLabelByXpath(String s) {
        return By.xpath(labelByTextXpath.replace("NAME", s));
    }

    public By getProductsButtonSelector() {
        return By.cssSelector(productsButtonSelector);
    }

    //checks the checkbox from the leftside menu of the criteria
    public void checkFilterCheckbox(String s){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(getLabelByXpath(s)));
        c.click();
    }

    //combined action of hovering on products button, tv and audio and finally clicking on tv
    public void hoverAndClickTV(){
        Actions action = new Actions(driver);
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(getProductsButtonSelector()));
        action.moveToElement(we).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector(tvSubDivisionSelector))).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector(tvSelector))).click().build().perform();
    }

    //expand manufacturor dropdown
    public void clickOnManufacturer(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(manufacturerExpandSelector)));
        c.click();

    }
    //expand screntype dropdown
    public void clickOnScreenType(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(screenTypeExpandSelector)));
        c.click();
    }
    //expand screensize dropdown
    public void clickOnScreenSize(){
        WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(screenSizeExpandSelector)));
        c.click();
    }

    public List<WebElement> getProductList(){
        WebElement productsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-list")));
        List<WebElement> products = productsList.findElements(By.tagName("h2"));
        return products;
    }


}
