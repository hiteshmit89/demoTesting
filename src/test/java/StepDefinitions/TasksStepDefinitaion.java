package StepDefinitions;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TasksStepDefinitaion {

    @Given("I Am login to PbN app")
    public void iAmLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(1,1));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(1,1));
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @When("I am clicking on practice name")
    public void iClickOnPracticeName() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(1));
    }

    @And("I am redirected to the Tasks Page")
    public void iAmRedirectedToTheTasksPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Tasks);
    }

    @When("I search for created task through patient name")
    public void iSearchForCreatedTaskThroughPatientName() {
        PbNUIApp.tasksPage().searchTaskViaPatientName();
    }

    @Then("I selected a task from task list")
    public void iSelectedATaskFromTaskList() {
        PbNUIApp.tasksPage().selectTaskFromTaskList();
    }

    @And("Task section will open for that patient")
    public void taskSectionWillOpenForThatPatient() {
        PbNUIApp.tasksPage().closePatientWindow();
    }

    @And("Verified task Section is opened")
    public void verifiedTaskSectionIsOpened() {
        PbNUIApp.tasksPage().verifyTaskListHeader();
    }

    @And("I closed task list section")
    public void iClosedTaskListSection() {
        PbNUIApp.tasksPage().closeTaskListInPatientWindow();
    }

    @Then("I verified patient window open for the selected patient")
    public void iVerifiedPatientWindowOpenForTheSelectedPatient() {
        PbNUIApp.tasksPage().verifyPatientWindowForSelectedPatient();
    }
}