@PatientWindow @pbnAll
Feature: Patient Window Feature

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
      | General Task         |
      | Account Receivable   |


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
      | Patient Information     |

    @PatientFormsReminder @PUA-50 @PRAC-T975
    Scenario Outline: User can send the Reminder to the patient
      Given I login to PbN app and select the practice
      When I click on the patient finder to open Patient Window
      And I click on the Forms Tab
      And I click on the Send General and Consent Form Button "<Forms Type>" in patient window
      Then I click on the send reminder bell icon "<Forms Type>" in patient window
      Examples:
        | Forms Type              |
        | Dental Insurance Form   |
        | Patient Information     |

   @patientFormCancelInvite @PUA-50 @PRAC-T975
   Scenario Outline: User can cancel form invite from the Pending Forms List
    Given I login to PbN app and select the practice
    When I click on the patient finder to open Patient Window
    And I click on the Forms Tab
    And I click on the Send General and Consent Form Button "<Forms Type>" in patient window
    Then I cancel form Invite from the pending forms list "<Forms Type>" in patient window
    Examples:
      | Forms Type              |
      | Dental Insurance Form   |
      | Patient Information     |

  @patientFormsManuallySubmitted @PUA-50 @PRAC-T975
  Scenario Outline: User can manually complete the forms from the Pending Forms List
    Given I login to PbN app and select the practice
    When I click on the patient finder to open Patient Window
    And I click on the Forms Tab
    And I click on the Send General and Consent Form Button "<Forms Type>" in patient window
    And I Select the Form and Mark as submitted manually from the Pending Form List "<Forms Type>" in the patient window
    Then I verify check list is getting updated in the Completed Forms Section "<Forms Type>" in the patient window
    Examples:
      | Forms Type              |
      | Dental Insurance Form   |
      | Patient Information     |

  @optedOutPatientList @PRAC-T2492 @PUA-41
  Scenario: Verify that "Opted Out Patient" section is able to see in the Communication
    Given I login to PbN app and select the practice
    When I click on the patient finder to open Patient Window
    And I click in the Details Tab
    And I verify Email and Text Preferences
    When I click on Profile icon
    And I am able to click on settings
    And I click on the Opted Out Patients in the Communication Section
    Then I verify that Patient is available in the opted Out Patients list

  @PaymentCharge @PUA-63 @PRAC-T3473 @InProgress
  Scenario: The Payment Methods tab in the Charge pop window
    Given I login to PbN app and select the practice
    When I click on the patient finder to open Patient Window
    And I click on the charge Button
    And I click on the payment method
    And I select Add new payment method and enter the card details
    And I click on the save button