@HomeFeature @pbnAll
Feature: Home

  @home
  Scenario: Verify I can click on practice name to see details
    Given I login to PbN app
    When I click on practice name
    Then I will see activity for practice

