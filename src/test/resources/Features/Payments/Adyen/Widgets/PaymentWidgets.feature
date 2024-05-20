@PaymentFeature @pbnAll @PUA-8
Feature: Verify As a user I am able to make payment through widget link
  
  @Payments @PRAC-T3753 @PUA-8
  Scenario: Verify user is able to click on payment widgets
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then The user is able to click on Payments tab
    And The user is able to click on widgets tab

  @Payments @PRAC-T3753 @PUA-8
  Scenario: Verify user is able to redirect to Online Payment Portal through widget link
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then The user is able to click on Payments tab
    And The user is able to click on widgets tab
    And The user is able to copy widget link and navigate to payment screen

  @Payments @PRAC-T3753 @PUA-8
  Scenario: Verify if user is able to navigate to payment portal using widget link
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then The user is able to click on Payments tab
    And The user is able to click on widgets tab
    And The user is able to copy widget link and navigate to payment screen
    And The user is able to enter amount in Payment box

  @In-progress
  Scenario: Verify if user is able to checkout
    Given I enter credentials
    When I click login button
    And I am able to select practice
    Then The user is able to click on Payments tab
    And The user is able to click on widgets tab
    And The user is able to copy widget link and navigate to payment screen
    And The user is able to enter amount in Payment box
    And The  user is able to click on Pay full amount button and redirect to checkout screen
    And The user is able to complete the payment




