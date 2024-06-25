package StepDefinitions;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TasksStepDefinitaion {

/*
    @And("I am redirected to the Tasks Page")
    public void iAmRedirectedToTheTasksPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Tasks);
    }*/

    @When("I selected a task from task list")
    public void iSelectedATaskFromTaskList() {
        PbNUIApp.tasksPage().selectTaskFromTaskList();
    }

    @Then("Task section will open for that patient")
    public void taskSectionWillOpenForThatPatient() {
        PbNUIApp.tasksPage().closePatientWindow();
    }
}
