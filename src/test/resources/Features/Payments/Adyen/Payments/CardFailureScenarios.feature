@CardFailure @pbnAll
Feature: Charge a patient via Card through Payments showing in CTA menu and verify the result in Payments

    @PRAC-T3511 @PUA-20
    Scenario: Verify when user is trying with Incorrect CVV
        Given I enter credentials
        When I click login button
        And I am able to select practice
        Then I am redirected to home page
        And I click on the Floating Payment CTA
        And I select payment method and enter card details with incorrect cvc and verify incorrect cvv error message