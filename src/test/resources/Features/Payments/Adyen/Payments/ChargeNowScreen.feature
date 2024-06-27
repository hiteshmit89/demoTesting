@PaymentModal @pbnAll
Feature:  When I want to charge or request payment from a patient via Webapp, I want to see a CTA which I can easily so that I do need to take the multiple & different steps

  @PRAC-T3718 @PUA-71
  Scenario: Verify user is able to see charge now screen when click on Charge CTA floating button
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Payment CTA

  @PRAC-T3720 @PUA-83
  Scenario: Verify user is able to click on Charge now button from profile icon through comm center
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Comms Center CTA
    And I Search the patient
    And I click on three dots of patient Avatar
    And I click on Charge

  @PRAC-T3721 @PUA-85
  Scenario: Verify user is able to click on Request Payment button from profile icon
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Comms Center CTA
    And I Search the patient
    And I click on three dots of patient Avatar
    And I click on Request payment

  @PRAC-T3717 @PUA-86
  Scenario: Verify user is able to see new button on the botton od the floating icons
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I am able to see "Payment" floating button
