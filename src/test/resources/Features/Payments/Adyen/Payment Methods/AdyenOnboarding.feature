@AdyenFeature @pbnAll
Feature: Verify As a user I am able to onboard a practice to adyen payment service

  @EnableAdyenToggle @PRAC-T3745 @PUA-12
  Scenario: Charge a patient via Card through Payments showing in CTA menu and verify the result in Payments
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on Profile icon
    Then  I am able to click on settings
    And I am able to enable toggle for adyen feature