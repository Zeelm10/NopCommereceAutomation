package org.example.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
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
    public void sleepBrowser(int ms) throws InterruptedException {//if you want to wait then call this method and pass the time
        Thread.sleep(ms);
    }

    public String getTitle(){//used for validation or asserttion to get title(name visible in tab above the URL)
        return driver.getTitle();
    }

    public WebElement waitUntilElementIsClickable(WebElement element){//this is explicit wait for specific element until its clickable  .So you save time if its clicks before given time
        WebDriverWait wait = new WebDriverWait(driver,30);
        return     wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element, int timeout, String failureMessage) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(failureMessage);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollTo(WebElement element) {//
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void takeElementscreenshot(WebElement element, String fileName)  {
        File scnFile =element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" +fileName+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(Scenario scenario){

        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);//95 ,96 codes to attach screenshots for generating report in byte form
        scenario.embed(screenShot, "image/png");
//take a screen shot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//98 t0 105 to save screenshots on local device in file form

        try {
            FileUtils.copyFile(scrFile, new File("C:/Users/HARRY/Desktop/ScreenShot/Error.jpg"));
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int generateRandomNumber(){
        Random random = new Random();
        // Obtain a number between [0 - 49].
        return random.nextInt(50);
    }

    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }
}
