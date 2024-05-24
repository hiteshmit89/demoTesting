@LoginFeature @pbnAll
Feature: Login

  @PatientPortal @login @PUA-58 @PRC-T3128

  Scenario: Verify I can login to Patient Portal
    Given I enter user credential
    When I click on SignIn Button
    And I am able to select practices
    Then I am navigated to Dashboard