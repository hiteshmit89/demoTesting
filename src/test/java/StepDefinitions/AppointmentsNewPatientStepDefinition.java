package StepDefinitions;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnIDoNotHaveInsurance();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnUseCellPhone();
        PbNUIApp.appointmentBookingPage().enterOTP("1234");
    }

    @Then("I will be able to see successful message for appointment booking.")
    public void iWillBeAbleToSeeSuccessfulMessageForAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifySuccessfulTextDisplayed();
    }
}