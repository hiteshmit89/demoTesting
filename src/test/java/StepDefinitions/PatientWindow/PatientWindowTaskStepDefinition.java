package StepDefinitions.PatientWindow;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientWindowTaskStepDefinition {
    @When("I see activity for practice")
    public void iWillSeeActivityForPractice() {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }

    @And("I click on patient finder & open Patient Window")
    public void iClickOnPatientFinderOpenPatientWindow() {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getPatient_name());
    }

    @And("I click on task button & opted {string}")
    public void iClickOnTaskButtonOpted(String taskType) {
        if (taskType.equals(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_type())) {

        } else {
            PbNUIApp.patientWindowPage().selectTask(taskType);
        }
    }

    @And("I added description")
    public void iAddedDescription() {
        PbNUIApp.patientWindowPage().addTaskDescription(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_description());
    }

    @Then("I added task due date")
    public void iAddedTaskDueDate() {
        PbNUIApp.patientWindowPage().taskDueDate();
    }

    @And("I created a task")
    public void iCreatedATask() {
        PbNUIApp.patientWindowPage().taskCreation();
    }

    @And("I closed patient Window")
    public void iClosedPatientWindow() {
        PbNUIApp.patientWindowPage().closePatientWindow();
    }

    @And("I am redirected to the Task Page")
    public void iAmRedirectedToTheTaskPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Tasks);
    }

    @And("I search for created task through task description")
    public void iSearchForCreatedTaskThroughTaskDescription() {
        PbNUIApp.tasksPage().searchTask(PbNUIApp.userdata().getPractices().getFirst().getPatientData().getFirst().getTask_description());
    }

    @And("I selected tasks of search result")
    public void iSelectedTasksOfSearchResult() {
        PbNUIApp.tasksPage().selectTaskListCheckbox();
    }

    @And("I closed the created Tasks")
    public void iClosedTheCreatedTasks() {
        PbNUIApp.tasksPage().closeSelectedTaskList();
    }
}