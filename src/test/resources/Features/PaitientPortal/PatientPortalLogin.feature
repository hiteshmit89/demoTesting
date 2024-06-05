@LoginFeature @pbnAll @QA1Only
Feature: Login

  @PatientPortal @login @PUA-58 @PRC-T3128
  Scenario: Verify I can login to Patient Portal
    Given I enter user credential
    When I click on SignIn Button
    And I am able to select practices
    Then I am navigated to Dashboard


  @PatientPortal @login @PUA-69 @PRC-T3129
  Scenario: Verify I cannot login to Patient Portal with Invalid Credential
    Given I enter Invalid user credential
    When I click on SignIn Button
    Then I will see Error Message
