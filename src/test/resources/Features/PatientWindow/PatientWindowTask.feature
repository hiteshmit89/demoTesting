@PatientWindowTask @pbnAll
Feature: Patient Window Task Creation
  Description : Creating Tasks from patient window.

  @createPatientWindowTasks @PUA-46 @PRAC-T4049 @PRAC-T4050  @PRAC-T4051 @PRAC-T4052 @PRAC-T4053 @PRAC-T1455
  Scenario Outline: Verify User can create "<TaskType>" of tasks from patient window & close them from Task Page
    Given I Am login to PbN app
    And I am clicking on practice name
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

  @testSectionIntegrationWithPatientWindow @PRAC-T3763  @pbnAll
  Scenario: Patient Task Table Opening from Task Section
    Given I Am login to PbN app
    And I am clicking on practice name
    And I am redirected to the Task Page
    When I search for created task through patient name
    And I selected a task from task list
    And Verified task Section is opened
    Then I verified patient window open for the selected patient
    And I closed patient Window
