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