@AdyenFeature
Feature: Verify As a user I am able to onboard a practice to adyen payment service

# Author : pankaj.kumar@practicenumbers.com
# Jira Task Id: https://practicebynumbers.atlassian.net/browse/PUA-12

  @EnableAdyenToggle
  Scenario: Verify user is able to enable toggle for adyen service
    Given I enter user credentials
    When I click on login button
    And The user is able to select practice
    Then I am navigated to home page
    When The user is able to click on Profile icon
    Then  The user is able to click on settings
    And The user is able to enable toggle for adyen feature






