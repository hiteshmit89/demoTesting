@AppointmentsFeature @pbnAll
Feature: Appointments

  @appointments @PUA-19 @PRAC-T2749
  Scenario: Verify I should not be able to book appointment for patient who has Automation tag
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for patient who has Automation tag
    Then I will not be able to book appointment with message