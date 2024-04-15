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

  @appointments @PUA-14 @PRAC-T2750
  Scenario: Verify I should not be able to book appointment for inactive patient who has insurance
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for inactive patient who has insurance
    Then I will not be able to book appointment with message

  @appointments @PUA-19 @PRAC-T2749
  Scenario: Verify I should not be able to book appointment for patient who has Automation tag
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for patient who has Automation tag
    Then I will not be able to book appointment with message

  @PUA-42 @PRAC-T1197
  Scenario: Verify that I can book an appointment though scheduler
    Given I login to PbN app and select the practice
    When I click on schedule on floating chatbox and try to book appointment from scheduler
    Then I will be able to book appointment from scheduler

  @appointments @PRAC-T1064 @In-Progress
  Scenario: Verify I can Book the appointments for new patient
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for new patient
    Then I will be able to see successful message for appointment booking.