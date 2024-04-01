@PatientWindowTask @pbnAll
Feature: Patient Window Task Creation
  Description : Creating Tasks from patient window.

  @createPatientWindowTasks
  Scenario Outline: Verify I can create All task types from patient window
    Given I login to PbN app
    And I click on practice name
    Then I see activity for practice
    And I click on patient finder & open Patient Window
    And I click on task button & opted "<TaskType>"
    And I added task due date
    Then I created a task
    Examples:
      | TaskType             |
      | General Task         |
      | Account Receivable   |
      | Patient Recall       |
      | Patient Reactivation |