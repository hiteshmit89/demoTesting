@AppointmentsFeature @pbnAll
Feature: Appointments

  @appointments @PUA-31
  Scenario: Verify I can not see insurance page on Appointment booking when insurance feature is inactive
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and deactivate insurance settings
    And I click on appointments tab and try to book appointment
    Then I will not be able to see insurance page on appointment booking page.