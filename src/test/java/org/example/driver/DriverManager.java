package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    String browser = "Chrome";
    String baseUrl = "https://demo.nopcommerce.com/";

    public DriverManager(){
        PageFactory.initElements(driver,this);
    }
    public void openLocalBrowser() throws IllegalAccessException {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "Safari":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "Firefox":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            default:
                throw new IllegalAccessException("Unexpected Browser");
        }
    }

    public void maxBrowser(){
        driver.manage().window().maximize();
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void closeBrowser(){

        driver.quit();
    }

    public void openUrl(){
        driver.get(baseUrl);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
