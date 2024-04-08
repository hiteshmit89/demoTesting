@AppointmentScheduler @pbnAll
Feature: AppointmentScheduler

  @InProgress @PUA-42 @PRAC-T1197
  Scenario: Verify that I can book an appointment though scheduler
    Given I login to PbN app and select the practice
    When I click on schedule on floating chatbox and try to book appointment from scheduler
    Then I will be able to book appointment from scheduler