@AppointmentScheduler @pbnAll
Feature: AppointmentScheduler

  Scenario: Verify that I can book an appointment though scheduler
    Given I login to PbN app and select the practice
    And I click on schedule on floating chatbox
    When I click on appointments Setting tab and deactivate insurance settings
    And I click on appointments tab and try to book appointment
    Then I will not be able to see insurance page on appointment booking page.