@AppointmentsFeature @pbnAll
Feature: Appointments

  @appointments @PUA-32
  Scenario: Verify I can see credit card page on Appointment booking when credit card feature is active
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and activate credit card settings
    And I click on appointment tab and try to book appointment
    Then I will be able to see credit card page on appointment booking page.

  @appointments @PUA-31 @PRAC-T1619
  Scenario: Verify I can not see insurance page on Appointment booking when insurance feature is inactive
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and deactivate insurance settings
    And I click on appointments tab and try to book appointment
    Then I will not be able to see insurance page on appointment booking page.