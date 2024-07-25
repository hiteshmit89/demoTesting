@CardFailure @pbnAll
Feature: CardFailureFeature

    @PRAC-T3511 @PUA-20
    Scenario: Verify when user is trying with Incorrect CVV
        Given I enter credentials
        When I click login button
        And I am able to select practice
        Then I am redirected to home page
        And I click on the Floating Payment CTA
        And I enter the Patient Name
        And I enter the Amount
        And I select payment method and enter card details with incorrect cvc and verify incorrect cvv error message