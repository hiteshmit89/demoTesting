Feature: Functionality of Patient Task List

@ViewTasks
  Scenario: Verify ViewTasksList Table Displayed

    Given I login to PbN app
    When I click on practice name
    Then I will see activity for practice
    When I select search finder to open the patient window
    And I select the View Tasks
    And I select the open Button
    And I select In progress Button
    Then ViewTasks all button should be disabled
    Then I select the closed button and Verify the all Tasks in closed state
    Then I select the open button and Verify the all Tasks in open state
    Then I select the In progress button and Verify the all Tasks In progress state

