package StepDefinitions;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class AppointmentsNewPatientStepDefinition {
    @Given("I login to PbN app and select the practice")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail("chris.lau@practicenumbers.com");
        PbNUIApp.loginPage().enterPassword("ppp###2025");
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.homePage().clickOnPracticeInPracticeInfoTable("Romans, Burke and Wagner");
    }

    @When("I click on appointments tab and try to book appointments for new patient")
    public void iClickOnAppointmentsAndTryToBookAppointmentsForNewPatient() {


        /*assert PbNUIApp.appointmentsPage() != null;*/
        PbNUIApp.homePage().clickOnAppointmentsTab();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().clickOnCopyUrl();
        PbNUIApp.appointmentsPage().clickOnPickLocation();



    }
    @Then("I will be able to book appointments")
    public void iWillBookAppointments() {
        PbNUIApp.homePage().verifyWelcomeTextDisplayed();
    }
}

