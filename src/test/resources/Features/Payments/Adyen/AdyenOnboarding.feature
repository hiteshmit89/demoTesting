@AdyenFeature
Feature: Verify As a user I am able to onboard a practice to adyen payment service

# Author : pankaj.kumar@practicenumbers.com
# Jira Task Id: https://practicebynumbers.atlassian.net/browse/PUA-12

  @EnableAdyenToggle
  Scenario: Verify user is able to enable toggle for adyen service
    Given The User is able to login
    And The user is able to select practice
    And   The user in on HomePage
    When The user is able to click on Profile icon
    Then  The user is able to click on settings
    Then The user is able to enable checkbox for adyen






