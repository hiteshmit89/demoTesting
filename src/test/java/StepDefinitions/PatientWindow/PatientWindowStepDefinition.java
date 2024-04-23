package StepDefinitions.PatientWindow;

import Framework.Root.PbNUIApp;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientWindowStepDefinition {

    @When("I create a task {string} in patient window")
    public void iCreateATaskTaskTypeInPatientWindow(String taskType) {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf("Sally Walker");
        if (taskType.equals(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_type())) {
            PBNModals.patientOverviewModal().selectTask(taskType);
        } else {
            PBNModals.patientOverviewModal().selectTask(taskType);
        }
        PBNModals.patientOverviewModal().addTaskDescription(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_description());
        PBNModals.patientOverviewModal().taskDueDate();
        PBNModals.patientOverviewModal().taskCreation();
    }

    @And("I select the View Tasks")
    public void iSelectTheViewTasks() {
        PBNModals.patientOverviewModal().clickViewTasksList();
    }

    @And("I select the open Button")
    public void iSelectTheOpenButton() {
        PBNModals.patientOverviewModal().clickOpenTasksButton();
    }

    @And("I select In progress Button")
    public void iSelectInProgressButton() {
        PBNModals.patientOverviewModal().clickInProgressTasksButton();
    }

    @Then("ViewTasks all button should be disabled")
    public void viewTasksAllButtonShouldBeDisabled() {
        PBNModals.patientOverviewModal().validateNoTaskAvailableButtonStatus();
    }

    @And("I select the relevant button and Verify the all Tasks in {string} state")
    public void iSelectTheRelevantButtonAndVerifyTheAllTasksInState(String status) {
        PBNModals.patientOverviewModal().validateTaskStatus(status);
    }

    @When("I click on the patient finder to open Patient Window")
    public void iClickOnThePatientFinderToOpenPatientWindow() {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf("Sally Walker");
    }

    @And("I click on the Forms Tab")
    public void iClickOnTheFormsTab() {
        PBNModals.patientOverviewModal().clickOnForms();
    }

    @And("I click on the Send General and Consent Form Button {string} in patient window")
    public void iClickOnTheSendGeneralAndConsentFormButton(String formName) {
        PBNModals.patientOverviewModal().clickOnGeneralConsentFormsButton(formName);
        PBNModals.patientOverviewModal().clickOnPatientSelectedForm();
        PBNModals.patientOverviewModal().clickOnSearchForms(formName);
        PBNModals.patientOverviewModal().checkListOfSelectedForms(formName);
        PBNModals.patientOverviewModal().clickOnFormsSendButton();
    }

    @Then("I Verify check list is getting updated in the Pending Forms Section {string} in patient window")
    public void iVerifyCheckListIsGettingUpdatedInThePendingFormsSection(String formsName) {
        PBNModals.patientOverviewModal().verifyPendingFormsCheckList(formsName);
    }
}