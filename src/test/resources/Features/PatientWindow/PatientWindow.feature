@PatientWindow @pbnAll
Feature: Functionality of Patient Window

  @ViewTasks @PUA-7 @PRAC-T3494
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

  @PatientForms @PUA-45 @PRAC-T3451
  Scenario Outline: User can send the Forms to any patient and its will reflect in the Pending Forms List
    Given I login to PbN app and select the practice
    When I click on the patient finder to open Patient Window
    And I click on the Forms Tab
    And I click on the Send General and Consent Form Button "<Forms Type>" in patient window
    Then I Verify check list is getting updated in the Pending Forms Section "<Forms Type>" in patient window
    Examples:
      | Forms Type              |
      | Dental Insurance Form   |
      | Clinical Photo Transfer |

  @SmsValidation @PUA-67 @PRAC-T3791 @InProgress
  Scenario Outline: Exclamation mark triangle displayed for invalid SMS numbers
    Given I login to PbN app
    And I click on practice name
    When I search for "<Patient>" and open patient window
    Then I verify for the SMS number
    Examples:
      | Patient     |
      | New Mareez  |
      | Naya Mareez |