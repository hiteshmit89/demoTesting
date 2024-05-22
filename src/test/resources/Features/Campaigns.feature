@CampaignsFeature @pbnAll
Feature: Campaigns

  @PUA-33 @PRAC-T3573
  Scenario: Verify I can redirect to campaigns page
    Given I login to PbN app
    And I click on practice name
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    Then I am redirected to the campaigns page

  @PUA-34 @PRAC-T3573
  Scenario: : Verify Follow-up campaigns UI
    Given I login to PbN app
    And I click on practice name
    And I click on profile dropdown
    When I click on "Campaigns" dropdown option
    And I am redirected to the campaigns page
    Then I check for "<followUpCampaigns>" UI
    Examples:
    |followUpCampaigns|
    |Recall Campaign|
    |Review Request Campaign|
    |Christmas Holiday Greeting|
    |Root Canal|

