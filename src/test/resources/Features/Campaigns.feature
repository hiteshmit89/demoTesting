@CampaignsFeature
Feature: Campaigns

  @Campaigns
  Scenario: Verify I can redirect to campaigns page
    Given I login to PbN app
    And I click on practice name
    And I click on profile dropdown
    When I click on "Campaigns"
    Then I am redirected to the campaigns page

  Scenario: Verify Follow-up campaigns UI
    Given I login to PbN app
    And I click on practice name
    And I click on profile dropdown
    When I click on "Campaigns"
    Then I am redirected to Follow-up campaigns tab