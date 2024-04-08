package StepDefinitions;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientWindowStepDefinition {

    @When("I select search finder to open the patient window")
    public void iSelectSearchFinderToOpenThePatientWindow() {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf("Sally Walker");
    }

    @And("I click on task button & opted {string}")
    public void iClickOnTaskButtonOpted(String taskType) {
        if (taskType.equals(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_type())) {
            PbNUIApp.patientOverviewPage().selectTask(taskType);
        } else {
            PbNUIApp.patientOverviewPage().selectTask(taskType);
        }
    }

    @And("I added description")
    public void iAddedDescription() {
        PbNUIApp.patientOverviewPage().addTaskDescription(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_description());
    }

    @Then("I added task due date")
    public void iAddedTaskDueDate() {
        PbNUIApp.patientOverviewPage().taskDueDate();
    }

    @And("I created a task")
    public void iCreatedATask() {
        PbNUIApp.patientOverviewPage().taskCreation();
    }
    @And("I select the View Tasks")
    public void iSelectTheViewTasks() {
        PbNUIApp.patientOverviewPage().clickViewTasksList();
    }

    @And("I select the open Button")
    public void iSelectTheOpenButton() {
        PbNUIApp.patientOverviewPage().clickOpenTasksButton();
    }

    @And("I select In progress Button")
    public void iSelectInProgressButton() {
        PbNUIApp.patientOverviewPage().clickInProgressTasksButton();
    }

    @Then("ViewTasks all button should be disabled")
    public void viewTasksAllButtonShouldBeDisabled() {
        PbNUIApp.patientOverviewPage().validateAllButtonStatus();
    }

    @Then("I select the relevant button and Verify the all Tasks in {string} state")
    public void iSelectTheRelevantButtonAndVerifyTheAllTasksInState(String status) {
        PbNUIApp.patientOverviewPage().validateTaskStatus(status);
    }
}