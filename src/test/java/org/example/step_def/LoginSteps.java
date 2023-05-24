package org.example.step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.LoginPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginSteps extends DriverManager {
    LoginPage loginPage = new LoginPage();

    @Then("^I should see \"([^\"]*)\" text$")
    public void i_should_see_text(String expectedText) throws Throwable {
        String actualText = loginPage.getWelcometext();
        assertEquals(expectedText,actualText);
    }

    @Then("^the URL should contain \"([^\"]*)\"$")
    public void the_URL_should_contain(String expectedText) throws Throwable {
        String myURL = getURL();
        assertThat(myURL,containsString(expectedText));
    }
}
