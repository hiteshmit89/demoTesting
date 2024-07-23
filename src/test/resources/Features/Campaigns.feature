@CampaignsFeature @pbnAll
Feature: Campaigns

  @PUA-33 @PRAC-T3573 @PRAC-T3576
  Scenario: Verify I can redirect to campaigns page
    Given I login to PbN app for campaign
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    Then I am redirected to the campaigns page

  @PUA-34 @PRAC-T4056
  Scenario Outline: : Verify Follow-up campaigns UI
    Given I login to PbN app for campaign
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    And I am redirected to the campaigns page
    Then I check for "<followUpCampaigns>" UI
    Examples:
    |followUpCampaigns|
    |Failed Appointments Campaign|
    |Review Request Campaign|
    |Christmas Holiday Greeting|
    |Root Canal|

  @PUA-21 @PRAC-16855
  Scenario: Verify I can edit and save email template of primary early reminder without invalid merge tag notification
    Given I login to PbN app
    And I click on practice name
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    And I try to edit and save email template of primary early reminder with invalid merge tag notification
    Then I will be able to edit and save email template of primary early reminder invalid merge tag notification

  @PUA-54 @PRAC-T4334
  Scenario: : To verify, campaign can be set up and mark as active
    Given I login to PbN app for campaign
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    And I am redirected to the campaigns page
    And I activate the "Appointment Reminders Campaign" campaign
    Then I open "Appointment Reminders Campaign" campaign
