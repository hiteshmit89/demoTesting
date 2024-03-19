
package StepDefinitions.PatientWindow;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class PatientWindowTaskStepDefinition {

    @Given("I will login to PbN app")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail("chris.lau@practicenumbers.com");
        PbNUIApp.loginPage().enterPassword("ppp###2025");
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @When("I will click on practice name")
    public void iClickOnPracticeName()
    {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable("Roman, Burke and Wagner");
    }

    @Then("I see activity for practice")
    public void iWillSeeActivityForPractice()
    {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }

    @And("I click on patient finder & open Patient Window")
    public void iClickOnPatientFinderOpenPatientWindow() throws InterruptedException
    {
        PbNUIApp.navigator().findAndSelectPatientByExactMatchOf("Charles Abbott");
        //PbNUIApp.patientWindowPage().openPatientWindow("Charles Abbott");
    }

    @Then("I click on task button & added description")
    public void iClickOnTaskButtonAddedDescription()  throws InterruptedException
    {

        PbNUIApp.patientWindowPage().createTaskInPatientWindow("Automation");
    }

    @And("I added task due date")
    public void iAddedTaskDueDate()
    {
        PbNUIApp.patientWindowPage().taskDueDate();
    }


    @Then("I created a task")
    public void iCreatedATask(){
        PbNUIApp.patientWindowPage().taskCreation();

    }


    @Given("I am login to PbN app")
    public void iAmLoginToPbNApp()
    {
        PbNUIApp.loginPage().enterEmail("chris.lau@practicenumbers.com");
        PbNUIApp.loginPage().enterPassword("ppp###2025");
        PbNUIApp.loginPage().clickOnLoginButton();
    }



}

