@PaymentTable @pbnAll
Feature: payment details in Payment table

  @PRAC-T3947 @PUA-112
  Scenario: user is able to see label in Payment table
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment from side nav
    Then I able to see labels in the Payment table

  @PRAC-T3949 @PUA-113
  Scenario: Transactions within this time frame should display a refund icon with a Dollar sign
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then I am redirected to home page
    When I click on payments from header nav
    And I Click on Payment from side nav
    Then I able to see a refund icon with a Dollar sign