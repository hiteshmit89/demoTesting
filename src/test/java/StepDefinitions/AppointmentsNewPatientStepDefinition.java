package StepDefinitions;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Pages.AppHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class AppointmentsNewPatientStepDefinition {
    @Given("I login to PbN app and select the practice")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getEmail());
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getPassword());
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());
    }

    @When("I click on appointments tab and try to book appointments for new patient")
    public void iClickOnAppointmentsAndTryToBookAppointmentsForNewPatient() {


        /*assert PbNUIApp.appointmentsPage() != null;*/
        PbNUIApp.appHomePage().clickOnAppointmentsTab();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().clickOnCopyUrl();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().enterFirstName("Test First Name");
        PbNUIApp.appointmentBookingPage().enterLastName("Test Last Name");
        PbNUIApp.appointmentBookingPage().enterPhoneNumber("1234567890");
        PbNUIApp.appointmentBookingPage().enterEmailID("test@test.com");
        PbNUIApp.appointmentBookingPage().enterBirthDate("01011976");
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnIDontHaveInsurance();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnUseCellPhone();


    }

    @Then("I will be able to book appointments")
    public void iWillBookAppointments() {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }
}

