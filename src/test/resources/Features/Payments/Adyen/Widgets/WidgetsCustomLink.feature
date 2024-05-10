@AdyenWidgets @pbnAll @PUA-51
Feature: Verify user is able to proceed for payment using custom link in payments

  @AdyenWidgets @PRAC-T3754 @In-Progress @PUA-51
  Scenario: Verify user is able to proceed for payment using custom link in payments
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Widgets from side nav
    And I enter custom text to create link
    And I verify custom lnk is available
    And I verify that custom link is getting saved
    And I click on copy icon
    And I am able to open custom link in new tab and append the URL and Hot enter
    And I am able to payment portal link
    And I am able to enter first name, Last name and Birthdate of the patient and click continue
    And i am able to enter payment amount, statement number and account number and click pay full amount button
    And I am able to select card and able to enter card number, Expiry date and CVC code
    And I am able to click on Pay now Button
    And I am able to verify payment successfully message