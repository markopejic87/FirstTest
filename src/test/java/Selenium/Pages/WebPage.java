package Selenium.Pages;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class WebPage {

    protected WebDriverWait wait;
    protected WebDriver driver;

    /**
     * time to sleep before the click on some element [ms]
     */
    public static final int SLEEP_TIME = 500;


    public WebPage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

}
