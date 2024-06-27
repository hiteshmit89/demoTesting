@FormsPreviewFeature @pbnAll
Feature: Forms Feature

  @PRAC-T627 @PUA-4
  Scenario: Verify I can see forms table
    Given I login to PbN app
    And I click on practice name
    When I click on the forms
    Then I will see heading Completed forms

  @PRAC-T646 @PUA-4
  Scenario: Verify I can see list of  not synced forms into PMS completed forms page
    Given I login to PbN app
    And I click on practice name
    And I click on the forms
    When I will see heading Completed forms
    Then  I click on toggle next to Only show completed forms that have not synced

  @PRAC-T2757 @PUA-4
  Scenario: Verify that User is able to click on preview icon
    Given I login to PbN app
    And I click on practice name
    And I click on the forms
    When  I will see heading Completed forms
    Then I Click on the preview icon

  @PRAC-T1283 @PUA-4
  Scenario: Verify that user is able to click on download icon
    Given I login to PbN app
    And I click on practice name
    And I click on the forms
    When  I will see heading Completed forms
    Then I click on download icon

  @PRAC-T627 @PUA-4
  Scenario: Verify that user is able to search patient on Completed forms page
    Given I login to PbN app
    And I click on practice name
    When I click on the forms
    Then I am able to search patient on completed forms page

  @PRAC-T1282 @PUA-4
  Scenario: Verify that user is able to select values from Custom drop down on Completed forms page
    Given I login to PbN app
    And I click on practice name
    When I click on the forms
    Then I click on Custom drop down on forms Page