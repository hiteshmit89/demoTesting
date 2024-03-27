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

    @Then("I select the closed button and Verify the all Tasks in closed state")
    public void iSelectTheClosedButtonAndVerifyTheAllTasksInClosedState() {
        PbNUIApp.patientOverviewPage().validateClosedStatus();
    }

    @Then("I select the open button and Verify the all Tasks in open state")
    public void i_select_the_open_button_and_verify_the_all_tasks_in_open_state() {
        PbNUIApp.patientOverviewPage().validateOpenStatus();
    }

    @Then("I select the In progress button and Verify the all Tasks In progress state")
    public void i_select_the_In_progress_button_and_verify_the_all_tasks_In_progress_state() {
        PbNUIApp.patientOverviewPage().validateInProgressStatus();
    }

}
