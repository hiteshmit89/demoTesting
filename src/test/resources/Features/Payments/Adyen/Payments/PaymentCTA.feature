@PaymentModal @pbnAll
Feature: Charge a patient via Card through Payments showing in CTA menu and verify the result in Payments

  @PRAC-T3664 @PUA-68 @In-Progress
  Scenario: Verify user is able to download the payment receipt for a patient already added cards
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Payment CTA
    And I enter the Patient Name
    And I enter the Amount
    And I select payment method and enter card details
    And I enter the charge description
    And I Click on Charge button on collect payment modal
    And I verify the payment successful modal
    And I am Able to download the payment receipt