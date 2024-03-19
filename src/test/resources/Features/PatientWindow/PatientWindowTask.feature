@PatientWindowTask
  Feature: Patient Window Task Creation

  @PatientWindowTask
  Scenario: Verify I can create a general type task
    Given I will login to PbN app
    When I will click on practice name
    Then I see activity for practice
    And I click on patient finder & open Patient Window
    And I click on task button & added description
    And I added task due date
    Then I created a task


