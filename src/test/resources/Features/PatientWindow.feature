@PatientWindow @pbnAll
Feature: Functionality of Patient Task List

  @ViewTasks @PUA_7
  Scenario Outline: User can create All types of tasks from patient window & ViewTasksList Table Displayed
    Given I login to PbN app
    When I click on practice name
    Then I will see activity for practice
    When I select search finder to open the patient window
    And I click on task button & opted "<TaskType>"
    And I added description
    And I added task due date
    And I created a task
    And I select the View Tasks
    And I select the open Button
    And I select In progress Button
    Then ViewTasks all button should be disabled
    Then I select the relevant button and Verify the all Tasks in "Closed" state
    Then I select the relevant button and Verify the all Tasks in "Open" state
    Then I select the relevant button and Verify the all Tasks in "In progress" state
    Examples:
      | TaskType             |
      | Patient Reactivation |
      | General Task         |
      | Account Receivable   |
      | Patient Recall       |