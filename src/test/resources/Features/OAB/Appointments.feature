@AppointmentsFeature @pbnAll
Feature: Appointments

  @appointments @PUA-32
  Scenario: Verify I can see credit card page on Appointment booking when credit card feature is active
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and activate credit card settings
    And I click on appointment tab and try to book appointment
    Then I will be able to see credit card page on appointment booking page.

  @appointments @PUA-19 @PRAC-T2749
  Scenario: Verify I should not be able to book appointment for patient who has Automation tag
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for patient who has Automation tag
    Then I will not be able to book appointment with message

  @appointments @PUA-14 @PRAC-T2750
  Scenario: Verify I should not be able to book appointment for inactive patient who has insurance
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for inactive patient who has insurance
    Then I will not be able to book appointment with message

  @PUA-42 @PRAC-T1197
  Scenario: Verify that I can book an appointment though scheduler
    Given I login to PbN app and select the practice
    When I click on schedule on floating chatbox and try to book appointment from scheduler
    Then I will be able to book appointment from scheduler

  @appointments @PUA-31 @PRAC-T1619
  Scenario: Verify I can not see insurance page on Appointment booking when insurance feature is inactive
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab and deactivate insurance settings
    And I click on appointments tab and try to book appointment
    Then I will not be able to see insurance page on appointment booking page.

  @appointments @PUA-48 @PRAC-T111
  Scenario: Verify DOB in insurance page on Appointment booking
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointment and select DOB less than Eighteen years on insurance page
    Then I will not be able to proceed to the next page if the insurance holder age is not less than Eighteen years.

  @appointments @PRAC-T1064 @In-Progress
  Scenario: Verify I can Book the appointments for new patient
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for new patient
    Then I will be able to see successful message for appointment booking.

  @appointments @PUA-57 @PRAC-T109
  Scenario: Verify I can see the refresh button on provider page during appointment booking
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments and navigate to provider page
    Then I will be able to see refresh button on provider page during appointment booking

  @appointments @PUA-92 @PRAC-T110
  Scenario: Verify DOB of patient in book myself page during Appointment booking
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointment and select DOB less than one year from current date on book myself page
    Then I will see a pop up appears asking for the patient's confirmation to proceed to the next page if the age is less than one years.