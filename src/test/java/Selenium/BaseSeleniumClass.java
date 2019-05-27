package Selenium;

import Selenium.Pages.PageTest;
import org.jboss.netty.channel.socket.ServerSocketChannelConfig;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSeleniumClass  {
    public WebDriver driver;
    public WebDriverWait wait;
    public String testServerUrl;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";


    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

    }

    public void setUpDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case CHROME:

                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
                break;

        }
    }

    @After
    public void tearDown()  {
        // Quit the browsers
        driver.quit();
    }
}
