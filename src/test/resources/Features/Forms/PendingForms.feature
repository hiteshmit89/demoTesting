@PendingFormsFeature @pbnAll
Feature: Forms Feature

  @PRAC-T4111 @PUA-30
    Scenario: Verify I can see pending forms table
    Given I login to PbN app
    And   I click on practice name
    When  I click on the forms
    And   I will click on the pending forms on the left hand side
    Then  I will search for a patient

       @PRAC-T4111 @PUA-30
      Scenario: Verify I click on custom filter
      Given I login to PbN app
      And   I click on practice name
      When  I click on the forms
      And   I will click on the pending forms on the left hand side
      Then  I will click on the custom filter

        @PRAC-T4111 @PUA-30
        Scenario: Verify that I can click on Bell icon
        Given I login to PbN app
        And   I click on practice name
        When  I click on the forms
        And   I will click on the pending forms on the left hand side
        And   I click on the send reminder bell icon
        Then  I click on yes button

        @PRAC-T4111 @PUA-30
        Scenario: Verify I click forms dropdown
        Given I login to PbN app
        And   I click on practice name
        When  I click on the forms
        And   I will click on the pending forms on the left hand side
        And   I click on the forms dropdown
        Then  I select option select all from dropdown
