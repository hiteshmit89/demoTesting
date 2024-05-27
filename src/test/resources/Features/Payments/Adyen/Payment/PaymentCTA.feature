Feature:

  @test
  Scenario: Verify user is able to enable toggle for adyen service
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Payment CTA
    And I enter the Patient Name
    And I select payment method and enter card details
    And I enter the Amount
    And I enter the charge description
    And I Click on Charge button on collect payment modal
    And I verify the payment successful modal
    And I am Able to download the payment receipt
