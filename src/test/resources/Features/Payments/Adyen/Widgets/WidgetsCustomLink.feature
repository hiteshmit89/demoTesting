@AdyenWidgets @pbnAll @PUA-51
Feature: Verify user is able to proceed for payment using custom link in payments

  @AdyenWidgets @PRAC-T3754 @pbnAll @PUA-51
  Scenario: Verify user is able to proceed for payment using custom link in payments
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment method from side nav