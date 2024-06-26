@AdyenTransaction @pbnAll @PUA-17
Feature: Verify As a user I am able Charge a patient using adyen payment services

  @AdyenTransaction @PRAC-T3356 @PUA-35 @In-Progress @PUA-73
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

  @AdyenTransaction @PRAC-T3496 @PUA-36 @In-Progress
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

  @AdyenTransaction @PRAC-T3353 @PUA-82  @In-Progress
  Scenario: Verify adyen card with Patient
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment method from side nav
    And I enter the Patient Name in payment methods
    And I able to see all adyen card present in the table using pagination
    Then i verify the adyen card with Patient

  @AdyenTransaction @PRAC-T3495 @PUA-37 @In-Progress
  Scenario: Verify user is able to charge patient adding a new card
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment method from side nav
    And I click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    Then I Click on Charge button