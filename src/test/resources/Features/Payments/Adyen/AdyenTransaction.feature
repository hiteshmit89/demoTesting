@AdyenTransaction @pbnAll
Feature: Verify As a user I am able Charge a patient using adyen payment services
"""
Author : pankaj.kumar@practicenumbers.com
Jira Task Id: https://practicebynumbers.atlassian.net/browse/PUA-17
"""
  @AdyenTransaction
  Scenario: Verify user is able to do successful transaction
    Given The User is able to login into the webapp
    And The user is able to select practices
    When User is able to click on payments from header nav
    And Click on Payment method from side nav
    And click on any card from payments table to charge patient
    And Select the payment method, enter amount, description from charge customer modal
    Then Click on Charge button
    And Verify Successful toast message









