@AppointmentsFeature @pbnAll
Feature: Appointments Settings

  @appointments @PUA-26 @PRAC-T1626
  Scenario: Verify I can see days and block-out times visibility on appointment booking setting page
    Given I login to PbN app and select the practice
    When I click on appointments Setting tab open provider setting
    Then I will be able to see days and block-out times visibility on appointment booking setting page

  @appointments @PUA-27 @PRAC-T1063
  Scenario: Verify I can see appointment list on appointment list page
    Given I login to PbN app and select the practice
    When I click on appointments list page and verify appointment list
    Then I will be able to see appointments list page list

  @appointments @PUA-28 @PRAC-T2618
  Scenario: Verify I can see advanced Settings window of provider on appointment setting page
    Given I login to PbN app and select the practice
    When I click on appointments setting page and verify advanced Settings window of provider
    Then I will be able to see advanced Settings window of provider

  @appointments @PUA-52 @PRAC-T2475
  Scenario: Verify I can add and remove provider list and visit type from appointment setting page
    Given I login to PbN app and select the practice
    When I click on appointments setting page and verify add and remove provider list and visit type from appointment setting page
    Then I will be able to add and remove provider list and visit type from appointment setting page

  @appointments @PUA-56 @PRAC-T1610
  Scenario: Verify I can select 15 min radio button from appointment setting page
    Given I login to PbN app and select the practice
    When I click on appointments setting page and verify fifteen min radio button from appointment setting page
    Then I will be able to select fifteen min radio button from appointment setting page

  @appointments @PUA-59 @PRAC-T102
  Scenario: Verify I can see appointment details on appointment list page
    Given I login to PbN app and select the practice
    When I click on appointments list page and verify appointment details
    Then I will be able to see appointments details on page list

  @appointments @PUA-64 @PRAC-T106
  Scenario: Verify I can filter appointments on appointment list page
    Given I login to PbN app and select the practice
    When I click on try to filter appointments on appointment list page
    Then I will be able to see filtered appointments on page list

  @appointments @PUA-60 @PRAC-T103
  Scenario: Verify I can see patient information on appointment list page
    Given I login to PbN app and select the practice
    When I click on appointments list page and verify patient information
    Then I will be able to see patient information on page list

  @appointments @PUA-65 @PRAC-T104
  Scenario: Verify I can sort columns of Appointment list table on appointment list page
    Given I login to PbN app and select the practice
    When I try to sort columns of Appointment list table on appointment list page
    Then I will be able to sort columns of Appointment list table on appointment list page

  @appointments @PUA-66 @PRAC-T105
  Scenario: Verify I can search the patient with patient name on appointment list page
    Given I login to PbN app with user id 1 and select the practice
    When I try to search the patient with patient name on appointment list page
    Then I will be able to search the patient with patient name on appointment list page

  @appointments @PUA-84 @PRAC-T118
  Scenario: Verify I can click on the provider time availability checkbox on appointment settings page
    Given I login to PbN app and select the practice
    When I try to click on the provider time availability checkbox on appointment settings page
    Then I will be able to click on the provider time availability checkbox on appointment settings page

  @appointments @PUA-88 @PRAC-T3842
  Scenario: Verify I can disable automatic messages on appointment template page
    Given I login to PbN app and select the practice
    When I try to click on and disable automatic messages on appointment template page
    Then I will be able to click and disable automatic messages on appointment template page

  @appointments @PUA-90 @PRAC-T98
  Scenario: Verify I can click on the cluster appointments checkbox on appointment settings page
    Given I login to PbN app and select the practice
    When I try to click on the cluster appointments checkbox on appointment settings page
    Then I will be able to click on the cluster appointments checkbox on appointment settings page

  @appointments @PUA-91 @PRAC-T3830
  Scenario: Verify I can select the language on the practice specific configuration popup on appointment settings page
    Given I login to PbN app and select the practice
    When I try to select the language on the practice specific configuration popup on appointment settings page
    Then I will be able to select the language on the practice specific configuration popup on appointment settings page

  @appointments @PUA-98 @PRAC-T121
  Scenario: Verify I can uncheck on the provider time availability checkbox on appointment settings page
    Given I login to PbN app and select the practice
    When I try to uncheck on the provider time availability checkbox on appointment settings page
    Then I will be able to uncheck on the provider time availability checkbox on appointment settings page

  @appointments @PUA-99 @PRAC-T141
  Scenario: Verify I can click on reset button on appointment template page
    Given I login to PbN app with super user and select the practice
    When I try to click on reset button on appointment template page
    Then I will be able to click reset button on appointment template

  @appointments @PUA-104 @PRAC-T127
  Scenario: Verify I can check and uncheck the Auto update the PMS with the booked appointments checkbox and Alert and don’t auto sync appointments on appointment settings page
    Given I login to PbN app and select the practice
    When I try to check and uncheck the Auto update the PMS with the booked appointments checkbox and Alert and don’t auto sync appointments on appointment settings page
    Then I will be able to check and uncheck the Auto update the PMS with the booked appointments checkbox and Alert and don’t auto sync appointments on appointment settings page

  @appointments @PUA-108 @PRAC-T1609
  Scenario: Verify that 10 minutes radio button is by default selected when scrolling down to Appointment Availability column on appointment settings page
    Given I login to PbN app and select the practice
    When I try to navigate to Appointment Availability column on appointment settings page
    Then I will be able to verify ten minutes radio button is by default selected when scrolling down to Appointment Availability column on appointment settings page

  @appointments @PUA-107 @PRAC-T1608
  Scenario: Verify that the user should be able to view two options 10 Minutes & 15 minutes under the heading Appointment Time Interval on the Appointment Availability column on the appointment settings page
    Given I login to PbN app and select the practice
    When I try to navigate to Appointment Availability column on appointment settings page
    Then I will be able to view two options ten Minutes & fifteen minutes under the heading Appointment Time Interval on the Appointment Availability column on the appointment settings page