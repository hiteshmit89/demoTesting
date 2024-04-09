@PatientWindow @pbnAll
Feature: Functionality of Patient Task List

  @ViewTasks @PUA_7
  Scenario Outline: User can create All types of tasks from patient window & ViewTasksList Table Displayed
    Given I login to PbN app
    And I click on practice name
    When I create a task "<TaskType>" in patient window
    And I select the View Tasks
    And I select the open Button
    And I select In progress Button
    Then ViewTasks all button should be disabled
    And I select the relevant button and Verify the all Tasks in "Closed" state
    And I select the relevant button and Verify the all Tasks in "Open" state
    And I select the relevant button and Verify the all Tasks in "In progress" state
    Examples:
      | TaskType             |
      | Patient Reactivation |
      | General Task         |
      | Account Receivable   |
      | Patient Recall       |