@PatientWindowTask @pbnAll
Feature: Patient Window Task Creation
  Description : Creating Tasks from patient window.

  @createPatientWindowTasks @PRAC-T4049 @PRAC-T4050  @PRAC-T4051 @PRAC-T4052 @PRAC-T4053
  Scenario Outline: Verify User can create "<TaskType>" of tasks from patient window & close them from Task Page
    Given I login to PbN app
    And I click on practice name
    And I click on patient finder & open Patient Window
    And I click on task button & opted "<TaskType>"
    And I added description
    And I added task due date
    And I created a task
    And I closed patient Window
    And I am redirected to the Task Page
    When I search for created task through task description
    Then I selected tasks of search result
    And I closed the created Tasks
    Examples:
      | TaskType             |
      | Patient Reactivation |
      | General Task         |
      | Account Receivable   |
      | Patient Recall       |

  @testSectionIntegrationWithPatientWindow @PRAC-T3763
  Scenario Outline: Patient Task Table Opening from Task Section
    Given I login to PbN app
    And I click on practice name
    And I am redirected to the Task Page
    When I selected a task from task list
    Then Task section will open for that patient

