@LoginFeature
Feature: Campaigns

  @login
  Scenario: Verify I can redirect to Campaigns page
    Given I click on profile dropdown
    When I click on Campaigns
    Then I am redirected to the campaigns page