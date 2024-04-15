package StepDefinitions.Appointments;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlockInactivePatientsWithInsuranceFromAppointmentBookingStepDefinition {
    @When("I click on appointments tab and try to book appointments for inactive patient who has insurance")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForInactivePatientWhoHasInsurance() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForInactivePatient();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will not be able to book appointment with message\\(Unable to book Appointment)")
    public void iWillNotBeAbleToBookAppointmentWithMessageUnableToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifyTextDisplayedMessage("Unable to book Appointment text is not displayed on appointment booking page");
    }
}
