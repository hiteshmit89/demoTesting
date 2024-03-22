@PatientWindowTask
  Feature: Patient Window Task Creation

    @GeneralTask
    Scenario: Verify I can create a general type task
      Given I login to PbN app
      And I click on practice name
      Then I see activity for practice
      And I click on patient finder & open Patient Window
      And I click on task button & added description
      And I added task due date
      Then I created a task

    @AccountReceivable
    Scenario: Verify I can create a Account Receivable type task
      Given I login to PbN app
      And I click on practice name
      Then I see activity for practice
      And I click on patient finder & open Patient Window
      And I click on task button & opted Account Receivable Task Type
      And I added task due date
      Then I created a task

      Scenario Outline: Verify I can create All task types from patient window
        Given I login to PbN app
        And I click on practice name
        Then I see activity for practice
        And I click on patient finder & open Patient Window
        And I click on task button & opted "<TaskType>"
        And I added task due date
        Then I created a task
        Examples:
        |TaskType|
        |General Task      |
        |Account Receivable|
        |Patient Recall    |
        |Patient Reactivation|
        |Treatment Follow-up |







