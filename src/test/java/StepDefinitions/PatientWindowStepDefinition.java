package StepDefinitions;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientWindowStepDefinition {

    @When("I create a task {string} in patient window")
    public void iCreateATaskTaskTypeInPatientWindow(String taskType) {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf("Sally Walker");
        if (taskType.equals(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_type())) {
            PbNUIApp.patientOverviewPage().selectTask(taskType);
        } else {
            PbNUIApp.patientOverviewPage().selectTask(taskType);
        }
        PbNUIApp.patientOverviewPage().addTaskDescription(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_description());
        PbNUIApp.patientOverviewPage().taskDueDate();
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

    @And("I select the relevant button and Verify the all Tasks in {string} state")
    public void iSelectTheRelevantButtonAndVerifyTheAllTasksInState(String status) {
        PbNUIApp.patientOverviewPage().validateTaskStatus(status);
    }
}