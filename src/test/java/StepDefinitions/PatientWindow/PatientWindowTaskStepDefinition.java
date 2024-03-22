
package StepDefinitions.PatientWindow;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class PatientWindowTaskStepDefinition {

    /* @Given("I will login to PbN app")
      public void iLoginToPbNApp() {
          PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getEmail());
          PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getPassword());
          PbNUIApp.loginPage().clickOnLoginButton();

      }
          @When("I will click on practice name")
          public void iWillClickOnPracticeName() {
              PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());

          }*/
    @Then("I see activity for practice")
    public void iWillSeeActivityForPractice() {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }

    @And("I click on patient finder & open Patient Window")
    public void iClickOnPatientFinderOpenPatientWindow() {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf(PbNUIApp.userdata().getPractices().getFirst().getPatient_name());

    }

    @When("I click on task button & added description")
    public void iClickOnTaskButtonAddedDescription() {
        PbNUIApp.patientWindowPage().createGeneralTaskInPatientWindow(PbNUIApp.userdata().getPractices().getFirst().getTask_description());
    }

    @Then("I added task due date")
    public void iAddedTaskDueDate() {
        PbNUIApp.patientWindowPage().taskDueDate();
    }

    @And("I created a task")
    public void iCreatedATask() {
        PbNUIApp.patientWindowPage().taskCreation();

    }

    @And("I click on task button & opted {string}")
    public void iClickOnTaskButtonOpted(String taskType) {
        if (taskType.equals(PbNUIApp.userdata().getPractices().getFirst().getTask_type())) {

        } else {
            PbNUIApp.patientWindowPage().selectTask(taskType);
        }
    }
}



