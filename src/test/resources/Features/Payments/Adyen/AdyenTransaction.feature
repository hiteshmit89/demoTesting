@AdyenTransaction
Feature: Verify As a user I am able Charge a patient using adyen payment services

# Author : pankaj.kumar@practicenumbers.com
# Jira Task Id: https://practicebynumbers.atlassian.net/browse/PUA-17
# Scenarios :Verify user is able to do successful transaction
# Verify user is able to download receipt
# Verify user is able to charge patient adding a new card
# Verify user is able to see the latest transaction in the payments table
# Verify user is able to see the payment sync when practice is configures with PMS

  @EnableAdyenToggle
  Scenario: Verify user is able to do successful transaction
    Given The User is able to login into the webapp
    And The user is able to select practice
    When User is able to click on payments from header nav
    And Click on Payment method from side nav
    Then click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    And Select charge convinience fee radio button
    Then Click on Charge button
    And Verify Successful toast message









