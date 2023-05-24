@Test
Feature: login feature
  As a user
  I want to add login functionality
  So that customer can use it

  @Test1
  Scenario: Validating sign in text on login page
    Given I am on homepage
    When I click on login button on homepage
    Then I should see "Welcome, Please Sign In!" text
    And the URL should contain "/login"

  @

#  Scenario: Login with Invalid Credential
#    Given I am on homepage
#    And I click on "log in" link on homepage
#    When I enter invalid credentials
#    Then I should see error message"Login was Unsuccessful."