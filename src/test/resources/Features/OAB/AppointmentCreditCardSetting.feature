@AppointmentsFeature @pbnAll
Feature: Appointments

  @appointments @PUA-32
  Scenario: Verify I can see credit card page on Appointment booking when credit card feature is active
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and activate credit card settings
    And I click on appointment tab and try to book appointment
    Then I will be able to see credit card page on appointment booking page.