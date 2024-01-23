@LoginFeature
Feature: Login

  @login
  Scenario: Verify I can login to pbn app
    Given I enter user credentials
    When I click on login button
    Then I am navigated to home page