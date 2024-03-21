@AppointmentsFeature
Feature: Appointments_Booking

  @appointments @in-progress
  Scenario: Verify I can Book the appointments for new patient
    Given I login to PbN app and select the practice
    When I click on appointments tab and try to book appointments for new patient
    Then I will be able to see successful message for appointment booking.