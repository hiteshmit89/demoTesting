@AdyenFeature
Feature: Verify As a user I am able to onboard a practice to adyen payment service

  @EnableAdyenToggle @PRAC-T3745 @pbnAll @PUA-12
  Scenario: Verify user is able to enable toggle for adyen service
    Given I enter credentials
    When I click login button
    And The user is able to select practice
    Then I am redirected to home page
    And The user is able to click on Profile icon
    Then  I am able to click on settings
    And The user is able to enable toggle for adyen feature






