@PaymentFeature @pbnAll
Feature: Verify As a user I am able to make payment through widget link
  
  @Payments @PUA-8 @In-progress
  Scenario: Verify user is able to click on payment widgets
    Given I login to PbN app and select the practice
    When The user is able to click on Payments tab
    Then The user is able to click on widgets tab

  Scenario: Verify user is able to redirect to Online Payment Portal through widget link
    Given I login to PbN app and select the practice
    When The user is able to click on Payments tab
    Then The user is able to click on widgets tab
    And The user is able to copy widget link and navigate to payment screen

  Scenario: Verify if user is able to make payment using widget link
    Given I login to PbN app and select the practice
    When The user is able to click on Payments tab
    Then The user is able to click on widgets tab
    When The user is able to copy widget link and navigate to payment screen
    Then The user is able to make payment




