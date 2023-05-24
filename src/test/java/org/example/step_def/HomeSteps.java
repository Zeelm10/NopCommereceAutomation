package org.example.step_def;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;

public class HomeSteps extends DriverManager {
    HomePage homePage = new HomePage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() throws Throwable {
        String myURL= getURL();
        assertThat(myURL,is(endsWith("nopcommerce.com/")));
    }

    @When("^I click on login button on homepage$")
    public void i_click_on_login_button_on_homepage() throws Throwable {
        homePage.clickOnLoginButton();
    }

}