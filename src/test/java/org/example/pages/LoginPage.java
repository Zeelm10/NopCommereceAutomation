package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(xpath = "//div[@class=\"center-1\"]/div/div/h1")
    WebElement welcomeText;
    @FindBy(id = "Email")
    WebElement email;
    public String validEmail ="Zeel1006@gmail.com";
    @FindBy(id = "Password")
    WebElement password;
    String validPassword ="123456";
    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    WebElement loginButton;
    @FindBy(className ="ico-account")
    WebElement myAccountButton;
    @FindBy(className = "ico-logout")
    WebElement logoutButton;

    public String getWelcometext(){
        String actualText = welcomeText.getText();     ///Welcome Sign in!
        return actualText;
    }
    public void enterEmail(){
        email.click();
        email.sendKeys(validEmail);
    }
    public void enterPassword(){
        password.click();
        password.sendKeys(validPassword);
    }

    public void clickLoginButton(){
        //method below is used for explicit wait
        waitForElementVisibility(loginButton,20,"login button is not visible");
        loginButton.click();
    }

    public void myAccountButtonVisible(){
        myAccountButton.isDisplayed();
    }
    public void myLogoutButtonVisible(){
        logoutButton.isDisplayed();
    }
}
