@AdyenTransaction @pbnAll @PUA-17
Feature: Verify As a user I am able Charge a patient using adyen payment services

  @AdyenTransaction @PRAC-T3356 @PUA-35
  Scenario: Verify user is able to do successful transaction and verify successful toast
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment method from side nav
    And I click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    Then I Click on Charge button
    And Verify Successful toast message

  @AdyenTransaction @PRAC-T3496 @PUA-36
  Scenario: Verify user is able to download Payment receipt
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment method from side nav
    And I click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    Then I Click on Charge button
    And Verify Successful toast message
    And Verify I am able to download Payment receipt