package Selenium;

import Selenium.Pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseSeleniumClass  {
    public WebDriver driver;
    public WebDriverWait wait;
    public String testServerUrl;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    public static final String URL = "https://www.winwin.rs";

    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public ConfirmationPage confirmationPage;
    public CheckoutPage checkoutPage;
    public Properties credentials;

    @Before
    public void setUp() throws Exception{
        setUpDriver(CHROME);
        testServerUrl=URL;
        initialize();
    }

    //Initilizes driver
    public void setUpDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, 30);
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
                wait = new WebDriverWait(driver, 30);
                break;

        }
    }

    public void initialize() {
        // Maximize the browser's window
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        //initializeProperties();

        //initialize pages
        homePage = new HomePage(wait, driver);
        loginPage = new LoginPage(wait, driver);
        confirmationPage = new ConfirmationPage(wait, driver);
        productPage = new ProductPage(wait,driver);
        checkoutPage = new CheckoutPage(wait,driver);
    }

    //Initialize propeties file that contains login credentials
    public void initializeProperties(){
        credentials = new Properties();
        try (FileReader in = new FileReader("credentials.properties")) {
            credentials.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown()  {
        // Quit the browsers
        driver.quit();
    }
}
