package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(xpath = "//div[@class=\"center-1\"]/div/div/h1")
    WebElement welcomeText;

    public String getWelcometext(){
        String actualText = welcomeText.getText();     ///Welcome Sign in!
        return actualText;
    }
}
