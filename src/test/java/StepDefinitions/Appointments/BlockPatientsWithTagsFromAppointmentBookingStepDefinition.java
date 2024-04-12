package StepDefinitions.Appointments;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class BlockPatientsWithTagsFromAppointmentBookingStepDefinition {
    @When("I click on appointments tab and try to book appointments for patient who has Automation tag")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForPatientWhoHasAutomationTag() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForPatientWithTags();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will not be able to book appointment with message\\(Unable to book Appointment).")
    public void iWillNotBeAbleToBookAppointmentWithMessageUnableToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifyTextDisplayedMessage();
    }

}