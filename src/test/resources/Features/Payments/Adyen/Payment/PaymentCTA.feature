Feature:

  @test
  Scenario: Verify user is able to enable toggle for adyen service
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    And I click on the Floating Payment CTA
    And I enter the Patient Name
    And I enter the Amount
    And I select payment method