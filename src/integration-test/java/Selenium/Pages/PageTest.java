package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTest extends WebPage{


    protected String linkSelector ="#search_form_input_homepage";
    protected String searchButtonId="#search_button_homepage";
    protected String toptalId="#r1-0 > div > h2 > a.result__a";
    protected String sideBarId="guide-button";

    public PageTest(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public By getLinkSelector() {
        return By.cssSelector(linkSelector);
    }
    public By getsearchButtonId() {
        return By.cssSelector(searchButtonId);
    }

    public By gettoptalId() {
        return By.cssSelector(toptalId);
    }

    public By getsideBarIdButtonId() {
        return By.id(sideBarId);
    }




}
