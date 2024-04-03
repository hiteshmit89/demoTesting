@PatientWindowTask @pbnAll
Feature: Patient Window Task Creation
  Description : Creating Tasks from patient window.

  @createPatientWindowTasks
  Scenario Outline: Verify User can create All types of tasks from patient window
    Given I login to PbN app
    And I click on practice name
    Then I see activity for practice
    And I click on patient finder & open Patient Window
    And I click on task button & opted "<TaskType>"
    And I added description
    And I added task due date
    Then I created a task
    And I closed patient Window
    And I am redirected to the Task Page
    And I search for created task through task description
    And I closed the created Tasks
    Examples:
      | TaskType             |
      | General Task         |
      | Account Receivable   |
      | Patient Recall       |
      | Patient Reactivation |