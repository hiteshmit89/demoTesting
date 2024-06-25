@PaymentMethod @pbnALL @QA1Only
  Feature: PaymentMethod

    @PatientPortal @PaymentMethod @PUA-87 @PRAC-T3233 @In-Progress
    Scenario: Verify I can Navigate to Payment Method and add a New Card
      Given I enter user credential
      And I click on SignIn Button
      And I am able to select practices
      And I am navigated to Dashboard
      And I am able to click on Payment Method Tab
      When I am navigate to Payment Method Page
      And I select Add new payment method and enter the card details


