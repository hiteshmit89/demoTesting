@AdyenTransaction @pbnAll
Feature: Verify As a user I am able Charge a patient using adyen payment services

  @AdyenTransaction @PRAC-T3356 @pbnAll @PUA-17
  Scenario: Verify user is able to do successful transaction and verify successful toast
    Given I enter credentials
    When I click login button
    And The user is able to select practice
    Then I am redirected to home page
    When User is able to click on payments from header nav
    And Click on Payment method from side nav
    And click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    Then Click on Charge button
    And Verify Successful toast message









