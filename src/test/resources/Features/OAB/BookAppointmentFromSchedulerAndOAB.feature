@AppointmentScheduler @pbnAll
Feature: AppointmentScheduler

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