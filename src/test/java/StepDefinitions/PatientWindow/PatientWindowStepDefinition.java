package StepDefinitions.PatientWindow;

import Framework.Root.PbNUIApp;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientWindowStepDefinition {

    @When("I create a task {string} in patient window")
    public void iCreateATaskTaskTypeInPatientWindow(String taskType) {
        if (taskType.equals(PbNUIApp.userdata().getTaskType(1, 1))) {
            PBNModals.patientOverviewModal().selectTask(taskType);
        } else {
            PBNModals.patientOverviewModal().selectTask(taskType);
        }
        PBNModals.patientOverviewModal().addTaskDescription(PbNUIApp.userdata().getTaskDescription(1, 1));
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
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf(PbNUIApp.userdata().getPatientName(1,1));
    }

    @And("I click on the Forms Tab")
    public void iClickOnTheFormsTab() {
        PBNModals.patientOverviewModal().clickOnForms();
    }

    @And("I click on the Send General and Consent Form Button {string} in patient window")
    public void iClickOnTheSendGeneralAndConsentFormButton(String formName) {
        PBNModals.patientOverviewModal().clickOnGeneralConsentFormsButton(formName);
        PBNModals.patientOverviewModal().clickOnSearchForms(formName);
        PBNModals.patientOverviewModal().checkListOfSelectedForms(formName);
        PBNModals.patientOverviewModal().clickOnFormsSendButton();
    }

    @Then("I Verify check list is getting updated in the Pending Forms Section {string} in patient window")
    public void iVerifyCheckListIsGettingUpdatedInThePendingFormsSection(String formsName) {
        PBNModals.patientOverviewModal().verifyPendingFormsCheckList(formsName);
    }

    @Then("I click on the send reminder bell icon {string} in patient window")
    public void iClickOnTheSendReminderBellIconInPatientWindow(String formName) {
        PBNModals.patientOverviewModal().sendReminderBell(formName);
    }

    @Then("I cancel form Invite from the pending forms list {string} in patient window")
    public void iCancelFormInviteFromThePendingFormsListInPatientWindow(String formName) {
        PBNModals.patientOverviewModal().clickOnCancelFormInvite(formName);
    }

    @And("I Select the Form and Mark as submitted manually from the Pending Form List {string} in the patient window")
    public void iSelectTheFormAndMarkAsSubmittedManuallyFromThePendingFormListInThePatientWindow(String formName) {
        PBNModals.patientOverviewModal().clickOnMarkAsSubmittedManuallyButton(formName);
    }

    @Then("I verify check list is getting updated in the Completed Forms Section {string} in the patient window")
    public void iVerifyCheckListIsGettingUpdatedInTheCompletedFormsSectionInThePatientWindow(String formName) {
        PBNModals.patientOverviewModal().verifyCompletedFormsCheckList(formName);
    }

    @And("I click in the Details Tab")
    public void iClickInTheDetailsTab() {
        PBNModals.patientOverviewModal().clickOnDetailsTab();
    }

    @And("I verify Email and Text Preferences")
    public void iVerifyEmailAndTextPreferences() {
        PBNModals.patientOverviewModal().clickOnCommunicationPreference();
    }

    @And("I click on the Opted Out Patients in the Communication Section")
    public void iClickOnTheOptedOutPatientsInTheCommunicationSection() {
        PBNModals.patientOverviewModal().clickOnOptedOutPatients();
    }

    @Then("I verify that Patient is available in the opted Out Patients list")
    public void iVerifyThatPatientIsAvailableInTheOptedOutPatientsList() {
        PBNModals.patientOverviewModal().verifyPatientOptedOutList();
    }

    @And("I click on the Patient Note")
    public void iClickOnThePatientNote() {
        PBNModals.patientOverviewModal().clickOnPatientNote();
    }

    @And("I enter the patient note and click on the Add Note Button")
    public void iEnterThePatientNoteAndClickOnTheAddNoteButton() {
        PBNModals.patientOverviewModal().clickOnAddPatientNote();
    }

    @Then("I verify patient note in the Activity Tab")
    public void iVerifyPatientNoteInTheActivityTab() {
        PBNModals.patientOverviewModal().verifyPatientNoteInActivityTab();
    }
}