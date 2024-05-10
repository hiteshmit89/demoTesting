@pbnAll
Feature: RevenueIQ Page

  @PUA-27
  Scenario: Interaction of the Patient Window with Revenue IQ
    Given I login to PbN app and select the practice
    When I navigate to the RevenueIQ page
    And I click on the Treatment
    And I Click on the Search Button
    Then  I Click on Patient Name to open their Patient Window